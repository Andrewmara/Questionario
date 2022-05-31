import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { QuestionarioUtente } from '../model/QuestionarioUtente';
import { Risposta } from '../model/Risposta';

@Injectable({
  providedIn: 'root'
})
export class RiposteUtenteService {
  url = "http://localhost:8091";
  constructor(private httpClient: HttpClient) { }

  addRisposteUtente(rispostaUtente: Risposta): Observable<Object>{
    return this.httpClient.post(`${this.url}/risposteUtente`, rispostaUtente);
  }

  postQuesteUtente(questutente: QuestionarioUtente): Observable<Object>{
    return this.httpClient.post(`${this.url}/questionarioutente`, questutente);
  }

}
