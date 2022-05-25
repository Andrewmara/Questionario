import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-sidenav-docente',
  templateUrl: './sidenav-docente.component.html',
  styleUrls: ['./sidenav-docente.component.css']
})
export class SidenavDocenteComponent implements OnInit {

  constructor(public router:Router) { }

  ngOnInit(): void {
  }

  isLista() {
    return this.router.url.includes("/listaQuestionari");
  }

  isCrea() {
    return this.router.url.includes("/newQuestionario");
  }

  logout(){
    localStorage.clear();
    this.router.navigate(['/']);
  }
}
