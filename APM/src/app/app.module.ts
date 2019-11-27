import { BrowserModule } from '@angular/platform-browser';
import { NgModule} from '@angular/core';
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
import { DoctorComponent } from './doctorHomePage/doctor.component';
import { ReactiveFormsModule } from '@angular/forms';
import { NurseComponent } from './nurseHomePage/nurse.component';
import { RecipeValidation } from './recipeValidation/recipeVal.component';
import { RequestForAbsence } from './requestForAbsence/requestForAbsence';
import { UserProfiles } from './UserProfiles/userProfiles.component';
import { nurseWorkCal } from './nurseWorkingCalendar/nurseWorkCal.component';
import { listOfAllPat } from './ListOfAllPatients/listOfAllPat.component';


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
    WelcomeComponent,
    DoctorComponent,
    NurseComponent,
    listOfAllPat,
    UserProfiles,
    nurseWorkCal,
    RequestForAbsence,    
    RecipeValidation
    ],
  imports: [
    BrowserModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
    RouterModule.forRoot([
      {path: 'registration', component: RegistrationComponent},
      {path: 'login', component: LoginComponent},
      {path: 'welcome', component: WelcomeComponent},
      {path: 'HomepageCCA', component: ClinicalCenterAdministratorCompoment},
      {path: 'HomepageDoctor', component: DoctorComponent},
      {path: 'HomepageNurse', component: NurseComponent},
      {path: 'HomepageNurse/listOfAllPat', component: listOfAllPat},
      {path: 'HomepageNurse/UserProfiles', component: UserProfiles},
      {path: 'HomepageNurse/nurseWorkCal', component: nurseWorkCal},
      {path: 'HomepageNurse/RequestForAbsence', component: RequestForAbsence},
      {path: 'HomepageNurse/RecipeValidation', component:RecipeValidation},
      {path: 'HomepageCCA/arrivedReq', component : arrivedRequest},
      {path: 'HomepageCCA/registerNewClinCenAdmin', component: RegisterNewClinicalCenterAdministrator},
      {path: 'HomepageCCA/addNewClinic', component: AddNewClinic},
      {path: 'HomepageCCA/createMedCod', component: createMedicamentCodeBook},
      {path: 'HomepageCCA/createDiagCod', component: createDiagnosisCodeBook}, 
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

