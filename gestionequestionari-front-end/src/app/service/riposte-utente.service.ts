import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { QuestionarioUtente } from '../model/QuestionarioUtente';
import { Risposta } from '../model/Risposta';

@Injectable({
  providedIn: 'root'
})
export class RiposteUtenteService {
  url = "http://192.168.1.230:8091/api";
  constructor(private httpClient: HttpClient) { }

  addRisposteUtente(rispostaUtente: Risposta): Observable<Object>{
    return this.httpClient.post(`${this.url}/risposteUtente`, rispostaUtente);
  }

  postQuesteUtente(questutente: QuestionarioUtente): Observable<Object>{
    return this.httpClient.post(`${this.url}/questionarioutente`, questutente);
  }

  deleteRispByUten(id_questionario: number,id_utente: number){
    return this.httpClient.delete<number>(`${this.url}/deleteRisp/${id_questionario}/${id_utente}`)
  }

}
