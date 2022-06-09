import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatButtonModule } from '@angular/material/button';
import { MatSidenavModule } from '@angular/material/sidenav';
import { MatIconModule } from '@angular/material/icon';
import { MatListModule } from '@angular/material/list';
import {MatCardModule} from '@angular/material/card';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { AdminComponent } from './admin/admin.component';
import { FormsModule } from '@angular/forms';
import { CandidatoComponent } from './candidato/candidato.component';
import { DocenteComponent } from './docente/docente.component';
import { SidenavAdminComponent } from './shared/sidenav-admin/sidenav-admin.component';
import { ListaComponent } from './admin/lista/lista.component';
import { ListPageComponent } from './admin/lista/list-page/list-page.component';
import { CreaUtenteComponent } from './admin/crea-utente/crea-utente.component';
import { CreaComponent } from './admin/crea-utente/crea/crea.component';
import { QuestionariComponent } from './admin/questionari/questionari.component';
import { DomandeComponent } from './domande/domande.component';
import { SidenavDocenteComponent } from './shared/sidenav-docente/sidenav-docente.component';
import { CreaQuestionarioComponent } from './docente/crea-questionario/crea-questionario.component';
import { ListaQuestionariComponent } from './docente/lista-questionari/lista-questionari.component';
import { PageListaComponent } from './docente/lista-questionari/page-lista/page-lista.component';
import { CreaPageComponent } from './docente/crea-questionario/crea-page/crea-page.component';
import {MatFormFieldModule} from '@angular/material/form-field';
import {MatSelectModule} from '@angular/material/select';
import {MatRadioModule} from '@angular/material/radio';
import { ReactiveFormsModule } from '@angular/forms';
import { ProfiloComponent } from './profilo/profilo.component';
import {MatDialogModule} from '@angular/material/dialog';
import { PopupComponent } from './shared/popup/popup.component';



@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    RegisterComponent,
    AdminComponent,
    CandidatoComponent,
    DocenteComponent,
    SidenavAdminComponent,
    ListaComponent,
    ListPageComponent,
    CreaUtenteComponent,
    CreaComponent,
    QuestionariComponent,
    DomandeComponent,
    SidenavDocenteComponent,
    CreaQuestionarioComponent,
    ListaQuestionariComponent,
    PageListaComponent,
    CreaPageComponent,
    ProfiloComponent,
    PopupComponent,


  ],
  imports: [
    FormsModule,
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    MatToolbarModule,
    MatButtonModule,
    MatSidenavModule,
    MatIconModule,
    MatListModule,
    MatCardModule,
    BrowserAnimationsModule,
    MatFormFieldModule,
    MatSelectModule,
    MatRadioModule,
    ReactiveFormsModule,
    MatDialogModule,

  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
