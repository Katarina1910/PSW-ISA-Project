import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HOME_PATH, LOGIN_PATH, REGISTRATION_PATH, 
  ADMIN_USERS_PATH, ADMIN_POSTS_PATH, MY_PROFILE_PATH, PROFILES_PATH_PARAMS
} from './config/router-paths';
import { PatientProfilePageComponent } from './patientProfilePage/patientProfilePage.component';
import { LoginComponent } from './login/login.component';
import { RegistrationComponent } from './registration/registration.component';
import { PatientProfileSettingsComponent } from './patientProfileSettings/patientProfileSettings.component';
import { GuestGuard } from 'src/guard';


const routes: Routes = [
  { path: LOGIN_PATH, component: LoginComponent, canActivate: [GuestGuard] },
  { path: REGISTRATION_PATH, component: RegistrationComponent, canActivate: [GuestGuard] },
  { path: MY_PROFILE_PATH, component: PatientProfileSettingsComponent, canActivate: [GuestGuard] },
  { path: PROFILES_PATH_PARAMS, component: PatientProfilePageComponent, canActivate: [GuestGuard] },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
