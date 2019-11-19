import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';

import { AppComponent } from './app.component';
import { RegistrationComponent } from './registration/registration.component';
import { LoginComponent } from './login/login.component';
import { RequestForConsultComponent } from './requestForConsult/requestForConsult.component';
import { ConsultTermComponent } from './consultTerm/consultTerm.component';
import { ClinicalCenterAdministratorCompoment } from './clinicalCenterAdmin/clinicalCenterAdmin.component';
import { arrivedRequest } from './arrivedRequest/arrivedRequest.component';
import { AddNewClinic } from './addNewClinic/addNewClinic.component';
import { RegisterNewClinicalCenterAdministrator } from './registerNewClinCenAdmin/registerNewClinCenAdmin.component';
import { createMedicamentCodeBook } from './createMedicamentCodeBook/createMedicamentCodeBookcomponent';
import { createDiagnosisCodeBook } from './createDiagCodeBook/createDiagCodeBook.component';
import { WelcomeComponent } from './home/welcome.component'
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

@NgModule({
  declarations: [
    AppComponent,
    RegistrationComponent,
    LoginComponent,
    RequestForConsultComponent,
    ConsultTermComponent,
    ClinicalCenterAdministratorCompoment,
    arrivedRequest,
    AddNewClinic,
    RegisterNewClinicalCenterAdministrator,
    createMedicamentCodeBook,
    createDiagnosisCodeBook,
    WelcomeComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule,
    RouterModule.forRoot([
      {path: 'registration', component: RegistrationComponent},
      {path: 'login', component: LoginComponent},
      {path: 'welcome', component: WelcomeComponent},
      {path: 'HomepageCCA', component: ClinicalCenterAdministratorCompoment},
      {path: 'HomepageCCA/arrivedReq', component : arrivedRequest},
      {path: 'consultTerm', component: ConsultTermComponent},
      {path: 'requestConsult', component: RequestForConsultComponent},
      {path: '', component: WelcomeComponent, pathMatch: 'full'},
      {path: '**', redirectTo: 'welcome', pathMatch: 'full'},
    ], {useHash: true}),
    BrowserAnimationsModule
  ], 
  bootstrap: [AppComponent]
})
export class AppModule { }

