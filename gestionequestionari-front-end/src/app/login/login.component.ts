import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { AuthenticationService } from './authentication.service';
import { HttpClient } from "@angular/common/http";
import { AuthGuardService } from "../service/auth-guard.service";
import { UtenteService } from 'app/service/utente.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  username: string = '';
  password: string = '';
  errorMessage = 'Invalid Credentials';
  successMessage: string = '';
  invalidLogin = false;
  loginSuccess = false;
  userRole!: string;
  url = 'localhost:4200/admin'
  currentUser = JSON.parse(localStorage.getItem('loggedUser') || '{}');

  userInfo!: any;
  constructor(
    private route: ActivatedRoute,
    private utenteService: UtenteService,
    private router: Router,
    private authenticationService: AuthenticationService,
    private http: HttpClient) { }

  ngOnInit() {
    if(this.currentUser!=null){
      this.authenticationService.userRole=this.currentUser.ruolo
      switch (this.currentUser.ruolo) {
        case ('amministratore'): {
          this.router.navigate(['/amministratore']);
          break;
        }
        case ('docente'): {
          this.router.navigate(['/docente']);
          break;
        }
        case ('candidato'): {
          this.router.navigate(['/candidato']);
          break;
        }
    }
  }
}

  handleLogin() {
    let userRole;
    this.authenticationService.authenticationService(this.username, this.password).subscribe((result) => {
      this.invalidLogin = false;
      this.loginSuccess = true;
      this.successMessage = 'Login Successful.';
      this.authenticationService.getUserRole(this.username).subscribe(role => {
        this.userRole = role;
        this.authenticationService.userRole = role;
        this.redirectAfterLogin();
      }, error => console.log(error));
    }, () => {
      this.invalidLogin = true;
      this.loginSuccess = false;
    });
    this.utenteService.getUserByEmail(this.username).subscribe(data => {
      localStorage.setItem('loggedUser', JSON.stringify(data))
    })


  }

  redirectAfterLogin() {
    switch (this.userRole) {
      case ('amministratore'): {
        this.router.navigate(['/amministratore']);
        break;
      }
      case ('docente'): {
        this.router.navigate(['/docente']);
        break;
      }
      case ('candidato'): {
        this.router.navigate(['/candidato']);
        break;
      }
    }
  }

  getUserRole() {
    return this.userRole;
  }
}
