import { Component, OnInit } from '@angular/core';
import { QuestionarioService } from 'app/service/questionario.service';
import { AdminService, user } from '../admin.service';

@Component({
  selector: 'app-questionari',
  templateUrl: './questionari.component.html',
  styleUrls: ['./questionari.component.css']
})
export class QuestionariComponent implements OnInit {
  nome!:string
  cognome!:string
  docenteNome!:string
  docenteCognome!:string

  constructor(public quest:QuestionarioService,public admin:AdminService) { }
  questList:any
  alldocenti:any
  docenti: Array<string> = [];
  nCand:Array<number> = [];
  media:Array<number> = [];
  size!:number
  ngOnInit(){
    this.quest.allQuestionari().subscribe(data=>{
      this.questList=data
      console.log(data)
      this.size=data.length
      for(let i=0;i<this.size;i++){
          this.admin.getUserById(this.questList[i].id_utente).subscribe(data=>{
          this.docenti[i]=data.nome +" "+ data.cognome
          this.admin.getCountCandidati(this.questList[i].id).subscribe(data=>{
          this.nCand[i]=data
          this.admin.getMediaPunteggi(this.questList[i].id).subscribe(data=>{
          this.media[i]=data
          if(this.media[i]<1){
            this.media[i]=0
          }
          })
          })
          },
            error=>{
              console.log(this.alldocenti)
            })
          }
      },
      error=>{
        console.log(error)

      }
      )
  }

  }


