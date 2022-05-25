import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AdminComponent } from './admin/admin.component';
import { CreaUtenteComponent } from './admin/crea-utente/crea-utente.component';
import { ListaComponent } from './admin/lista/lista.component';
import { CandidatoComponent } from './candidato/candidato.component';
import { CreaQuestionarioComponent } from './docente/crea-questionario/crea-questionario.component';
import { DocenteComponent } from './docente/docente.component';
import { ListaQuestionariComponent } from './docente/lista-questionari/lista-questionari.component';
import { DomandeComponent } from './domande/domande.component';
import { LoginComponent } from './login/login.component';
import { ProfiloComponent } from './profilo/profilo.component';
import { RegisterComponent } from './register/register.component';
import {AuthGuardService} from "./service/auth-guard.service";

const routes: Routes = [
  { path: "", redirectTo: "/login", pathMatch: "full" },
  { path: 'login', component:LoginComponent },
  { path: 'profilo', component:ProfiloComponent },
  { path: 'amministratore',
    canActivate: [AuthGuardService],
    canActivateChild: [AuthGuardService],
    component:AdminComponent,
    children: [
      { path: 'questionari', component:AdminComponent },
      { path: 'newUser', component:CreaUtenteComponent },
      { path: 'lista', component:ListaComponent }]
  },

  { path: 'register', component:RegisterComponent },
  { path: 'docente',
    canActivate: [AuthGuardService],
    canActivateChild: [AuthGuardService],
    component:DocenteComponent,
    children: [
      { path: 'newQuestionario', component:CreaQuestionarioComponent },
      { path: 'listaQuestionari', component:ListaQuestionariComponent }]
  },

  { path: 'candidato', component:CandidatoComponent, canActivate: [AuthGuardService]},
  { path: 'candidato/questionari/:id', component:DomandeComponent, canActivate: [AuthGuardService] },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
