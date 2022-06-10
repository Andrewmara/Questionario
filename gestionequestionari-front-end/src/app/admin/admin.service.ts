
import { HttpClient} from "@angular/common/http";
import { Injectable } from "@angular/core";

export interface user{
    id_utente:number,
    nome:string,
    cognome:string,
    email:string,
    password:string,
    ruolo:string


}

@Injectable({ providedIn: 'root' })
export class AdminService {
constructor(private http: HttpClient){}

getUser(user: user){
  return this.http.get<user>('http://localhost:8091/api/utenti')
  }

SignUp(nome:string,cognome:string,email:string,password:string,ruolo:string){
  return this.http.post<user>('http://localhost:8091/api/utenti',
  {
    nome:nome,
    cognome:cognome,
    email:email,
    password:password,
    ruolo:ruolo
  })
}

getUserById(id:number){
  return this.http.get<user>('http://localhost:8091/api/utenti/'+id)
  }

getCountCandidati(questionario:number){
  return this.http.get<number>('http://localhost:8091/api/questionarioutente/'+questionario)
}

getMediaPunteggi(questionario:number){
  return this.http.get<number>('http://localhost:8091/api/questionarioutente/media/'+questionario)
}

allQuestionari(){
  return this.http.get('http://localhost:8091/api/questionari');
}
}
