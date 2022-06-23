import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { QuestionarioUtente } from 'app/model/QuestionarioUtente';
import { UtenteService } from 'app/service/utente.service';
import { QuestionarioService } from '../service/questionario.service';

@Component({
  selector: 'app-profilo',
  templateUrl: './profilo.component.html',
  styleUrls: ['./profilo.component.css']
})
export class ProfiloComponent implements OnInit {
  results: any
  allquest: any
  alltitolodes: any
  pTot:Array<number> = [];
  prova:Array<any> = [];
  num:Array<number> = [];


  currentUser = JSON.parse(localStorage.getItem('loggedUser') || '{}');
  constructor(private router: Router, public service: QuestionarioService,private utenteService:UtenteService) {
   }


  ngOnInit(): void {

    //Guestionario Utente - punteggio
    this.service.getQuestOfUser(this.currentUser.id).subscribe((data: any) => {

    for(let i =0;i<data.length;i++){
      this.num[i]=data[i].punteggio
      this.service.getPuntTot(data[i].id_questionario).subscribe(data=>{
        console.log(data)
        this.pTot[i]=data
      })
    }
    })
    console.log(this.num)
    console.log(this.pTot)

    this.service.getTitoloDes(this.currentUser.id).subscribe(a=>{
      console.log(a)
      this.results=a
    })



  }
  logout() {
    localStorage.clear();
    this.router.navigate(['/']);
  }
  goToProfilo() {
    localStorage.clear();
    this.router.navigate(['profilo']);
  }

  back(){
    return  this.router.navigate(['/candidato']);
  }
}
