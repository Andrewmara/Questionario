
import { HttpClient} from "@angular/common/http";
import { Injectable } from "@angular/core";

export interface questionari{
    length: number;
    titolo:string,
    descrizione:string,
    docente:number,
    id_questionario:number
}

export interface domanda{
  domanda: string,
  punteggio: number,
  questionario: number,
  ris_due: string,
  ris_giusta: string,
  ris_tre: string,
  ris_uno: string
}

@Injectable({ providedIn: 'root' })
export class DocenteService {
constructor(private http: HttpClient){}
currentUser = JSON.parse(localStorage.getItem('loggedUser') || '{}');


getQuest(){
  return this.http.get<questionari>('http://localhost:8091/questionari/'+this.currentUser.id_utente)
  }

getCountCandidati(questionario:number){
  return this.http.get<number>('http://localhost:8091/questionarioutente/'+questionario)
}

getMediaPunteggi(questionario:number){
  return this.http.get<number>('http://localhost:8091/questionarioutente/media/'+questionario)
}
getUserQuest(questionario:number){
  return this.http.get('http://localhost:8091/questionarioutente/user/'+questionario)
}

getUserById(id:number){
  return this.http.get('http://localhost:8091/utenti/'+id)
  }

AddQuest(titolo:string,descrizione:string,docente:number){
  return this.http.post<questionari>('http://localhost:8091/questionari',
  {
    titolo:titolo,
    descrizione:descrizione,
    docente:docente
  })

}

AddDomanda(domanda:string,questionario:number,ris_giusta:string,ris_uno:string,ris_due:string,ris_tre:string,punteggio:number){
  return this.http.post<domanda>('http://localhost:8091/domande',
  {
    domanda:domanda,
    questionario:questionario,
    ris_giusta:ris_giusta,
    ris_uno:ris_uno,
    ris_due:ris_due,
    ris_tre:ris_tre,
    punteggio:punteggio

  })
}

punteggioUtente(utente:number,questionario:number){
  return this.http.get('http://localhost:8091/punteggio/'+questionario+'/'+utente)
}


}
