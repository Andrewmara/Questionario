import { Component, NgModule, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { MatRadioChange } from '@angular/material/radio';
import { DocenteService } from '../../docente.service';




interface domanda{
  domanda:string,
  risposta1:string,
  risposta2:string,
  risposta3:string,
  risposta4:string,
  punteggio:number,
  id:number,
  rispostagiusta:number,

}


@Component({
  selector: 'app-crea-page',
  templateUrl: './crea-page.component.html',
  styleUrls: ['./crea-page.component.css']
})



export class CreaPageComponent implements OnInit {

  public form!: {
		domande: domanda[];
	};
  formdata!:domanda
  num:Array<number> = [];
  j:number=1
  domande!:number
  prova:Array<number> = [];
  length:number=0
  radio!:number
  idQuest!:any
  idq!:any
  interval!:any
  i!:number
  rispostagiusta:Array<string> = [];
  currentUser = JSON.parse(localStorage.getItem('loggedUser') || '{}');

  constructor(public http:DocenteService) { }

  ngOnInit(): void {

    console.log(this.currentUser.id)
    this.form = {
			domande:[]
		};
    this.i=0;

    this.addDomanda();
  }


  onItemChange(n: { value: any; }){
    let i=0
    this.rispostagiusta[i]=n.value
    i++
    console.log(this.rispostagiusta)
  }

  radioChange(event: MatRadioChange) {
    this.radio=event.value
    console.log(this.radio)
    }


  public addDomanda(){
    this.form.domande.push({
      id:Date.now(),
      domanda:"",
      risposta1:"",
      risposta2:"",
      risposta3:"",
      risposta4:"",
      punteggio:0,
      rispostagiusta:0
    })
    this.i=this.i+1
  }

  public processForm(form:any){

		console.group( "Form Data" );
		console.log( this.form.domande );
    console.log(this.i)
		console.groupEnd();

		console.group( "Form Model" );
		console.log( form );
		console.groupEnd();

  }

  public richieste(form:any){
    console.group( "Richieste" );

    const titolo=form.value.titolo;
    const descrizione=form.value.descrizione;
    this.http.AddQuest(titolo,descrizione,this.currentUser.id).subscribe(data=>{
      this.idQuest=data
      console.log(titolo,descrizione)

    for(let i=0;i<this.form.domande.length;i++){
      const domanda=this.form.domande[i].domanda
      const punteggio=this.form.domande[i].punteggio
      const risposta1=this.form.domande[i].risposta1
      const risposta2=this.form.domande[i].risposta2
      const risposta3=this.form.domande[i].risposta3
      const risposta4=this.form.domande[i].risposta4
      const rispostagiusta=this.form.domande[i].rispostagiusta
      console.log(domanda,punteggio,risposta1,risposta2,risposta3,risposta4,rispostagiusta,this.idQuest)

          if(rispostagiusta==1){
          this.http.AddDomanda(domanda,this.idQuest,risposta1,risposta2,risposta3,risposta4,punteggio).subscribe(data=>{
            console.log(data)
          })
          }

          if(rispostagiusta==2){
          this.http.AddDomanda(domanda,this.idQuest,risposta2,risposta1,risposta3,risposta4,punteggio).subscribe(data=>{
            console.log(data)
          })
         }

         if(rispostagiusta==3){
          this.http.AddDomanda(domanda,this.idQuest,risposta3,risposta2,risposta1,risposta4,punteggio).subscribe(data=>{
            console.log(data)
          })
         }

         if(rispostagiusta==4){
          this.http.AddDomanda(domanda,this.idQuest,risposta4,risposta2,risposta3,risposta1,punteggio).subscribe(data=>{
            console.log(data)
          })
        }
    }


    form.reset()
    this.form = {
			domande:[]
		};
    this.i=0;

    this.addDomanda();

    },
    error=>{
      console.log(error)
      })
		console.groupEnd();

  }

  public removeDomanda( index: number ) : void {
		this.form.domande.splice( index, 1 );
    this.i=this.i-1

	}

}
