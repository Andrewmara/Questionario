import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { Router } from '@angular/router';
import { UtenteService } from 'app/service/utente.service';
import { PopupComponent } from 'app/shared/popup/popup.component';
import { Domande } from '../model/Domande';
import { Questionario } from '../model/Questionario';
import { Utente } from '../model/Utente';
import { QuestionarioService } from '../service/questionario.service';

@Component({
  selector: 'app-candidato',
  templateUrl: './candidato.component.html',
  styleUrls: ['./candidato.component.css']
})
export class CandidatoComponent implements OnInit {
  constructor(private service: QuestionarioService, private router: Router, private utenteService: UtenteService,public dialog: MatDialog) { }
  domande!: Domande[];
  quest!: Questionario[];
  utente!: Utente;
  already:Array<number>=[]
  titolo:Array<String>=[]

  currentUser = JSON.parse(localStorage.getItem('loggedUser') || '{}');
  ngOnInit(): void {
    this.getAllQuestionario()
    console.log(this.currentUser)


  }

  getAllQuestionario() {
    this.service.allQuestionari().subscribe(data => {
      console.log(data);
      this.quest = data;
      for(let i=0;i<this.quest.length;i++){
        this.service.AlreadyDone(this.quest[i].id_questionario,this.currentUser.id_utente).subscribe(data=>{
          console.log(data)
          this.titolo[i]=this.quest[i].titolo
          console.log(this.titolo)
          this.already[i]=data
          console.log(this.already)
        })
      }
    });
  }
  getcurrentUser() {
    console.log(localStorage.getItem('loggedUser'));
    console.log(this.currentUser)
  }

  getAllDomandeQuestById(id: number) {
    this.service.allDomandebyQuestId(id).subscribe(d => {
      console.log(d);
      this.domande = d;
    });
  }

  logout() {
    localStorage.clear();
    this.router.navigate(['/']);
  }
  goToProfilo() {
    this.router.navigate(['profilo']);
  }

  openDialog(i:number){
   this.dialog.open(PopupComponent,{
    data : {
      titolo : this.titolo[i],
      id_utente: this.currentUser.id_utente,
      id_quest: this.quest[i].id_questionario

    }
   });
  }

}
