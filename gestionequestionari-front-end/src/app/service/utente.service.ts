import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Utente } from '../model/Utente';
@Injectable({
  providedIn: 'root'
})
export class UtenteService {
  url = "http://localhost:8080";
  constructor(private httpClient: HttpClient) { }
  allUsers():Observable<Utente[]>{
    return this.httpClient.get<Utente[]>(`${this.url}` + '/utenti');
  }
  getUserById(id: number): Observable<Utente>{
    return this.httpClient.get<Utente>(`${this.url}/utenti/${id}`);
  }
  registration(utente: Utente): Observable<Object>{
    return this.httpClient.post(`${this.url}/utenti`, utente);
  }
  getUserByEmail(email: any): Observable<Utente>{
    return this.httpClient.get<Utente>(`${this.url}/utenti/email/${email}`);
  }
}
