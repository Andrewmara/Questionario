import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Utente } from '../model/Utente';
import { UtenteService } from '../service/utente.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {
  utente: Utente = new Utente();
  success=false

  constructor(private userService:UtenteService, private router: Router ) {
    this.utente.ruolo = "candidato"
  }

  ngOnInit(): void {
  }
  signUp(){
    this.userService.registration(this.utente).subscribe( data => {
      console.log(data);
      this.router.navigate(['/login']);

    },
    error => console.log(error));
    this.router.navigate(['/login']);
    this.success=true
  }
  onSubmit(){
    console.log(this.utente);
    this.signUp();
  }
}
