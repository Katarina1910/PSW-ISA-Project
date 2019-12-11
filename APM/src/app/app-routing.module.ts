import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HOME_PATH, LOGIN_PATH, REGISTRATION_PATH, 
  ADMIN_USERS_PATH, ADMIN_POSTS_PATH, MY_PROFILE_PATH, PROFILES_PATH_PARAMS
} from './config/router-paths';
import { PatientProfilePageComponent } from './patientProfilePage/patientProfilePage.component';
import { LoginComponent } from './login/login.component';
import { RegistrationComponent } from './registration/registration.component';
import { PatientProfileSettingsComponent } from './patientProfileSettings/patientProfileSettings.component';


const routes: Routes = [
  { path: LOGIN_PATH, component: LoginComponent },
  { path: REGISTRATION_PATH, component: RegistrationComponent },
  { path: MY_PROFILE_PATH, component: PatientProfileSettingsComponent },
  { path: PROFILES_PATH_PARAMS, component: PatientProfilePageComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
