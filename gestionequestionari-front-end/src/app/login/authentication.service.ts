import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { map } from 'rxjs/operators';
import {LoginComponent} from "./login.component";
import {Observable} from "rxjs";
import {error} from "@angular/compiler/src/util";

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {

  // BASE_PATH: 'http://localhost:8091'
  USER_NAME_SESSION_ATTRIBUTE_NAME = 'authenticatedUser'

  public username: string = '';
  public password: string = '';
  public userRole: string = '';

  constructor(private http: HttpClient) {

  }

  authenticationService(username: string, password: string) {
    return this.http.get(`http://192.168.1.230:8091/api/basicauth?noauthchallenge`,
      { headers: { authorization: this.createBasicAuthToken(username, password),  } }).pipe(map((res) => {
      this.username = username;
      this.password = password;
      this.registerSuccessfulLogin(username, password);
      console.log(this.username,this.password)
    }));
  }

  createBasicAuthToken(username: string, password: string) {
    return 'Basic ' + window.btoa(username + ":" + password)
  }

  registerSuccessfulLogin(username: string, password: string) {
    sessionStorage.setItem(this.USER_NAME_SESSION_ATTRIBUTE_NAME, username)
  }

  logout() {
    sessionStorage.removeItem(this.USER_NAME_SESSION_ATTRIBUTE_NAME);
    this.username = '';
    this.password = '';
  }

  isUserLoggedIn() {
    let user = sessionStorage.getItem(this.USER_NAME_SESSION_ATTRIBUTE_NAME)
    if (user === null) return false
    return true
  }

  getLoggedInUserName() {
    let user = sessionStorage.getItem(this.USER_NAME_SESSION_ATTRIBUTE_NAME)
    if (user === null) return ''
    return user
  }

  getUserRole(email: string): Observable<string> {
    // @ts-ignore
    return this.http.get<string>("http://192.168.1.230:8091/api/basicauth/" + email, {responseType: 'text'})
  }
}
