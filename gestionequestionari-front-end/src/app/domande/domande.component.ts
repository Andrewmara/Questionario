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
  id!: number
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
  constructor(private questionarioservice: QuestionarioService, private utenteService: UtenteService, public quest: QuestionarioService, public activatedRoute: ActivatedRoute, private ruservice: RiposteUtenteService, private router: Router) { }

  ngOnInit(): void {
    console.log(this.currentUser.id_utente)
    console.log(this.currentUser.email)
    console.log(this.currentUser.nome)



    this.getAllDomandeIdQuest()
    this.getAllQuestionario()



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
        if (data[i].id_questionario == this.id) {
          this.questName = data[i].titolo
        }
      }
    })
  }
  checkScore() {
    this.risposte.filter(risposta => {
      console.log(risposta)
      this.ruservice.addRisposteUtente(risposta).forEach(data => {
        console.log("fe")
      }
      );
    })

    this.questionarioservice.allDomande().forEach((domande) => {
      for (let i = 0; i < domande.length; i++) {
        for (let j = 0; j < this.risposte.length; j++) {
          if (domande[i].id_domanda == this.risposte[j].domanda) {
            if (domande[i].ris_giusta == this.risposte[j].risposta) {
              console.log("corretto")
              this.punteggioTot += domande[i].punteggio;
            } else {
              console.log("sbagliata")
            }
          }
        }
      }

      console.log("voto: " + this.punteggioTot)
      this.questUtente = new QuestionarioUtente(this.punteggioTot, Number(this.id), this.currentUser.id_utente)
      this.ruservice.postQuesteUtente(this.questUtente).subscribe(data => {
        console.log(data)
      })
    })
    // this.router.navigate(['/candidato']);
    this.text = "Prova Terminata!"
    this.color = "red"
  }
  radioChangeHandler(event: any) {

    this.selectedRisposta = event.target.value//Risposta
    this.selectedDomanda = event.target.name //Domanda

    if (!this.isExist(this.selectedDomanda)) {
      this.risposte.push(new Risposta(this.id, this.selectedDomanda, this.selectedRisposta));
    } else {
      this.indexToChange = this.risposte.findIndex((obj => obj.domanda == this.selectedDomanda));
      this.risposte[this.indexToChange].risposta = this.selectedRisposta
    }
  }

  isExist(domanda: any) {
    return this.risposte.some(function (d) {
      return d.domanda === domanda;
    });
  }
  startTimer() {
    this.interval = setInterval(() => {
      if (this.timeLeft > 0) {
        this.timeLeft--;
      } else {
        this.timeLeft = 600;
      }
    }, 1000)
  }
  startQuest() {
    this.beforeTest = false;
    this.afterState = true;
    this.text = "Prova Iniziata!"
    this.startTimer()
  }
  onItemChange(value: any) {
    console.log(" Value is : ", value);
  }
}