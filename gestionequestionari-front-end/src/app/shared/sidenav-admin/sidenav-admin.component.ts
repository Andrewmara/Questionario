import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-sidenav-admin',
  templateUrl: './sidenav-admin.component.html',
  styleUrls: ['./sidenav-admin.component.css']
})
export class SidenavAdminComponent implements OnInit {

  constructor(public router:Router) { }

  ngOnInit(): void {
  }

  isQuest() {
    return this.router.url.includes("/questionari");
  }

  isCrea() {
    return this.router.url.includes("/newUser");
  }


  isLista() {
    return this.router.url.includes("/lista");
  }


  logout(){
    localStorage.clear();
    this.router.navigate(['/']);
  }
}
