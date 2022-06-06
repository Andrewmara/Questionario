
import { Component, OnDestroy, OnInit } from '@angular/core';
import { user } from 'app/admin/admin.service';
import { QuestionarioService } from 'app/service/questionario.service';

import { DocenteService } from '../../docente.service';

@Component({
  selector: 'app-page-lista',
  templateUrl: './page-lista.component.html',
  styleUrls: ['./page-lista.component.css']
})
export class PageListaComponent implements OnInit{

  questList:any
  size!:number
  nCand:Array<number> = [];
  media:Array<number> = [];
  user:any
  profilo:any
  dropdown:Array<boolean>= []
  size2!:number
  utenti:Array<user>= [];
  cand:Array<number>=[]
  punteggi:Array<any>=[]
  pTot:Array<number>=[]

  constructor(public docente:DocenteService,public questserv:QuestionarioService) { }

  ngOnInit(){

  this.docente.getQuest().subscribe(data=>{
  this.questList=data
  this.size=data.length
  console.log(this.questList)
  for(let i=0;i<this.size;i++){
    this.dropdown[i]=false

    this.docente.getCountCandidati(this.questList[i].id_questionario).subscribe(data=>{
    this.nCand[i]=data
    this.docente.getMediaPunteggi(this.questList[i].id_questionario).subscribe(data=>{
    this.media[i]=data
    if(this.media[i]<1){
      this.media[i]=0}
    })
    })}
    },
    error=>{
    console.log(error)
    })
    }

    Open(l:number){
      for(let i=0;i<this.dropdown.length;i++){
        if(this.dropdown[i]==true){
          this.dropdown[i]=false
          this.user=[]

          console.log(this.dropdown[i])
        }
      }
      this.dropdown[l]=true
    }
    Close(i:number){
      this.dropdown[i]=false
      this.user=[]

    }

    utentiqu(idque:number){
      this.docente.getUserQuest(idque).subscribe(data=>{
        this.user=data
        for(let i =0;i<this.user.length;i++){
          this.docente.punteggioUtente(idque,this.user[i].id_utente).subscribe(data=>{
            this.punteggi[i]=data
            console.log(this.user)
            this.questserv.getPuntTot(this.questList[i].id_questionario).subscribe(data=>{
              this.pTot[i]=data
              console.log(this.pTot)
              })

          })
        }
      })


    }




}

