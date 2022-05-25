import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { AdminService } from '../../admin.service';

@Component({
  selector: 'app-crea',
  templateUrl: './crea.component.html',
  styleUrls: ['./crea.component.css']
})
export class CreaComponent implements OnInit {

  success=false

  constructor(public admin:AdminService) { }

  ngOnInit(): void {
  }

  onCreate(form: NgForm){

    const nome=form.value.nome;
    const cognome=form.value.cognome;
    const email=form.value.email;
    const password=form.value.password;
    const ruolo=form.value.ruolo


    this.admin.SignUp(nome,cognome,email,password,ruolo).subscribe(data=>{
      console.log(data)
      this.success=true

    },
    error=>{
      console.log(error)
      this.success=true
    })

    form.reset()

  }
}
