import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Domande } from '../model/Domande';
import { Questionario } from '../model/Questionario';
import { QuestionarioUtente } from '../model/QuestionarioUtente';

@Injectable({
  providedIn: 'root'
})
export class QuestionarioService {
  url = "http://localhost:8091";
  constructor(private httpClient: HttpClient) { }
  allQuestionari():Observable<Questionario[]>{
    return this.httpClient.get<Questionario[]>(`${this.url}` + '/questionari');
  }
  allDomande():Observable<Domande[]>{
    return this.httpClient.get<Domande[]>(`${this.url}` + '/domande');
  }
  allDomandebyQuestId(id: number):Observable<Domande[]>{
    return this.httpClient.get<Domande[]>(`${this.url}` + `/domande/questionario/${id}`);
  }

  getQuestOfUser(id: number): Observable<QuestionarioUtente>{
    return this.httpClient.get<QuestionarioUtente>(`${this.url}/questionarioutente/utente/${id}`);
  }

  getTitoloDes(id: number): Observable<QuestionarioUtente>{
    return this.httpClient.get<QuestionarioUtente>(`${this.url}/questionarioutente/titolo/${id}`);
  }

  getNumdomande(id: number): Observable<number>{
    return this.httpClient.get<number>(`${this.url}/domande/numero/${id}`);
  }
  getPuntTot(id: number): Observable<number>{
    return this.httpClient.get<number>(`${this.url}/domande/ptot/${id}`);
  }
  AlreadyDone(questionario:number, utente:number){
    return this.httpClient.get<number>(`${this.url}/questionarioutente/alreadyDone/${questionario}/${utente}`)
  }
  deleteQuest(questionario:number, utente:number){
    return this.httpClient.get<number>(`${this.url}/questionarioutente/delete/${questionario}/${utente}`)
  }
}
