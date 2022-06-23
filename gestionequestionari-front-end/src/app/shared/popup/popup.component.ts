import { Component, Inject, OnInit } from '@angular/core';
import { MAT_DIALOG_DATA } from '@angular/material/dialog';
import { Router } from '@angular/router';
import { QuestionarioService } from 'app/service/questionario.service';
import { RiposteUtenteService } from 'app/service/riposte-utente.service';


@Component({
  selector: 'app-popup',
  templateUrl: './popup.component.html',
  styleUrls: ['./popup.component.css']
})
export class PopupComponent implements OnInit {
  titolo!:string
  id_utente!:number
  id_questionario!:number
  constructor(@Inject(MAT_DIALOG_DATA) public data:any, public quest:QuestionarioService, public router:Router, public risp:RiposteUtenteService) {
  this.titolo=data.titolo
  this.id_utente=data.id_utente
  this.id_questionario=data.id_quest
  }

  ngOnInit(): void {
    console.log(this.id_questionario,this.id_utente,this.titolo)
  }

  DoQuestionario(){
    this.quest.deleteQuest(this.id_questionario,this.id_utente).subscribe(data=>{
      this.risp.deleteRispByUten(this.id_questionario,this.id_utente).subscribe(data=>{
        console.log(this.id_questionario,this.id_utente)
        this.router.navigate(['/candidato/questionari/',this.id_questionario]);
      })
    })
  }
}
