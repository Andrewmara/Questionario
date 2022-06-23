import { Component, ElementRef, OnInit, ViewChild } from '@angular/core';
import { FormControl, FormGroup, NgForm, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { UtenteService } from 'app/service/utente.service';
import { Domande } from '../model/Domande';
import { QuestionarioUtente } from '../model/QuestionarioUtente';
import { Risposta } from '../model/Risposta';
import { QuestionarioService } from '../service/questionario.service';
import { RiposteUtenteService } from '../service/riposte-utente.service';

@Component({
  selector: 'app-domande',
  templateUrl: './domande.component.html',
  styleUrls: ['./domande.component.css']
})
export class DomandeComponent implements OnInit {
  id = this.activatedRoute.snapshot.params['id'];
  domande!: Domande[];
  risposte: Array<Risposta> = []
  questUtente!: QuestionarioUtente
  timeLeft: number = 700;
  interval: any;
  beforeTest = true;
  afterState = false;
  selectedRisposta: any;
  selectedDomanda: any;
  indexToChange: any;
  questName!: any;
  user = sessionStorage.getItem('authenticatedUser')
  currentUser = JSON.parse(localStorage.getItem('loggedUser') || '{}');
  text!: string
  color = "green";
  punteggioTot = 0;
  pScore=0;
  ndomande!: number
  success=false
  corretto:Array<Boolean> =[]
  v=false

  constructor(private questionarioservice: QuestionarioService, private utenteService: UtenteService, public quest: QuestionarioService, public activatedRoute: ActivatedRoute, private ruservice: RiposteUtenteService, private router: Router) { }

  ngOnInit(): void {
    console.log(this.currentUser.id)
    console.log(this.currentUser.email)
    console.log(this.currentUser.nome)
    console.log(this.id)
    this.questionarioservice.getNumdomande(this.id).subscribe(data=>{
      this.ndomande=data
    })

    this.questionarioservice.getPuntTot(this.id).subscribe(ptot=>{
      this.pScore=ptot
    })

    this.questionarioservice.allQuestionari().subscribe(data => {
      console.log(data)
      for (let i = 0; i < data.length; i++) {
        if (data[i].id == this.id) {
          this.questName = data[i].titolo
        }
      }
    })

  }
  getAllDomandeIdQuest() {
    this.id = this.activatedRoute.snapshot.params['id'];
    this.questionarioservice.allDomandebyQuestId(this.id).subscribe(data => {
      console.log(data)
      this.domande = data;
    });
  }
  getAllQuestionario() {
    this.questionarioservice.allQuestionari().subscribe(data => {
      for (let i = 0; i < data.length; i++) {
        if (data[i].id == this.id) {
          this.questName = data[i].titolo
        }
      }
    })
  }
  checkScore() {

console.log(this.risposte)
    for(let i=0;i<this.risposte.length;i++){
      this.ruservice.addRisposteUtente(this.risposte[i]).forEach(data => {
        console.log(data)
      }
      );
    }

    this.questionarioservice.allDomande().forEach((domande) => {
      console.log(domande)
      for (let i = 0; i < domande.length; i++) {
        for (let j = 0; j < this.risposte.length; j++) {
          if (domande[i].id == this.risposte[j].id) {
            if (domande[i].giusta == this.risposte[j].risposta) {
              console.log("corretto")
              this.v=true
              this.corretto[i]=true
              this.punteggioTot += domande[i].punteggio;
            } else {
              console.log("sbagliata")
              this.v=true
              this.corretto[i]=false
            }
          }
        }
      }

      console.log(this.corretto)
      console.log("voto: " + this.punteggioTot)
      this.questUtente = new QuestionarioUtente(this.punteggioTot, Number(this.id), this.currentUser.id)
      this.ruservice.postQuesteUtente(this.questUtente).subscribe(data => {
        console.log(data)

      })
    })
    // this.router.navigate(['/candidato']);
    this.text = "Prova Terminata!"
    this.color = "red"
    this.success=true
    document.getElementById("submitAnswers")!.style.visibility="hidden";
    document.getElementById("tempo")!.style.visibility="hidden";
  }

  radioChangeHandler(event: any) {

    this.selectedRisposta = event.target.value//Risposta
    this.selectedDomanda = event.target.name //Domanda

    if (!this.isExist(this.selectedDomanda)) {
      this.risposte.push(new Risposta( this.selectedDomanda, this.id,this.currentUser.id, this.selectedRisposta));
    } else {
      this.indexToChange = this.risposte.findIndex((obj => obj.id == this.selectedDomanda));
      this.risposte[this.indexToChange].risposta = this.selectedRisposta
      console.log(this.risposte)
    }
  }

  isExist(id: any) {
    return this.risposte.some(function (d) {
      return d.id === id;
    });
  }
  startTimer() {
    let startDate = new Date();
    let second = startDate.getSeconds() + 600;
    let endDate = new Date()
    endDate.setSeconds(second);
    this.timeLeft = Math.floor((endDate.getTime() - startDate.getTime()) / 1000);
    this.interval = setInterval(() => {
      if (this.timeLeft > 0) {
        this.timeLeft = Math.ceil((endDate.getTime() - new Date().getTime()) / 1000);
      } else {
        clearInterval(this.interval);

        this.checkScore();
        this.domande.splice(0);
        // @ts-ignore

      }
    }, 1000)

  }
  startQuest() {
    this.beforeTest = false;
    this.afterState = true;
    this.text = "Prova Iniziata!"
    this.getAllDomandeIdQuest()

    this.startTimer()
    // @ts-ignore
    document.getElementById("submitAnswers").style.visibility="visible";



    // @ts-ignore
    document.getElementById("startExam").style.visibility="hidden";
  }
  onItemChange(value: any) {
    console.log(" Value is : ", value);
  }
  back(){
    return  this.router.navigate(['/candidato']);
  }
}
