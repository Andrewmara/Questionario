
import { HttpClient} from "@angular/common/http";
import { Injectable } from "@angular/core";

export interface questionari{
    length: number;
    titolo:string,
    descrizione:string,
    id:number,
    id_utente:number
}

export interface domanda{
  domanda: string,
  punteggio: number,
  id_questionario: number,
  ris_due: string,
  giusta: string,
  ris_tre: string,
  ris_uno: string
}

@Injectable({ providedIn: 'root' })
export class DocenteService {
constructor(private http: HttpClient){}
currentUser = JSON.parse(localStorage.getItem('loggedUser') || '{}');


getQuest(){
  return this.http.get<questionari>('http://localhost:8091/api/questionari/'+this.currentUser.id)
  }

getCountCandidati(id:number){
  return this.http.get<number>('http://localhost:8091/api/questionarioutente/'+id)
}

getMediaPunteggi(questionario:number){
  return this.http.get<number>('http://localhost:8091/api/questionarioutente/media/'+questionario)
}
getUserQuest(questionario:number){
  return this.http.get('http://localhost:8091/api/questionarioutente/user/'+questionario)
}

getUserById(id:number){
  return this.http.get('http://localhost:8091/api/utenti/'+id)
  }

AddQuest(titolo:string,descrizione:string,id_utente:number){
  return this.http.post<questionari>('http://localhost:8091/api/questionari',
  {
    titolo:titolo,
    descrizione:descrizione,
    id_utente:id_utente
  })

}

AddDomanda(domanda:string,id_questionario:number,giusta:string,ris_uno:string,ris_due:string,ris_tre:string,punteggio:number){
  return this.http.post<domanda>('http://localhost:8091/api/domande',
  {
    domanda:domanda,
    id_questionario:id_questionario,
    giusta:giusta,
    ris_uno:ris_uno,
    ris_due:ris_due,
    ris_tre:ris_tre,
    punteggio:punteggio

  })
}

punteggioUtente(utente:number,questionario:number){
  return this.http.get('http://localhost:8091/api/punteggio/'+questionario+'/'+utente)
}


}
