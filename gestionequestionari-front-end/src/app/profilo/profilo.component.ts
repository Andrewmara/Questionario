import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
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
  currentUser = JSON.parse(localStorage.getItem('loggedUser') || '{}');
  constructor(private router: Router, public service: QuestionarioService,private utenteService:UtenteService) { 
   }


  ngOnInit(): void {

    //Guestionario Utente - punteggio
    this.service.getQuestOfUser(this.currentUser.id_utente).subscribe((data: any) => {
      for (let i = 0; i < data.length; i++) {
        this.service.getTitoloDes(this.currentUser.id_utente).subscribe((titolodes:any) => {
          for(let j = 0; j < titolodes.length;j++){
            if(data[i].questionario == titolodes[j].id_questionario){
              data[i].titolo = titolodes[j].titolo
              data[i].descrizione = titolodes[j].descrizione
            }
          }
        })
      }
      console.log(data)
      this.results = data
    })

    //AllQUestionari 
    this.service.allQuestionari().subscribe(quest => {
      console.log(quest)
      this.allquest = quest
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
}
