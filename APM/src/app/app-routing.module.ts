import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HOME_PATH, LOGIN_PATH, REGISTRATION_PATH, 
  ADMIN_USERS_PATH, MY_PROFILE_PATH, PROFILES_PATH_PARAMS
} from './config/router-paths';
import { PatientProfilePageComponent } from './patientProfilePage/patientProfilePage.component';
import { LoginComponent } from './login/login.component';
import { RegistrationComponent } from './registration/registration.component';
import { PatientProfileSettingsComponent } from './patientProfileSettings/patientProfileSettings.component';
import { GuestGuard, AdminGuard, LoginGuard } from 'src/guard';
import { ClinicAdminHomePageComponent } from './clinicAdminHomePage/clinicAdminHomePage.component';
import { ForbiddenComponent } from './forbidden';


const routes: Routes = [
  { path: LOGIN_PATH, component: LoginComponent, canActivate: [GuestGuard] },
  { path: REGISTRATION_PATH, component: RegistrationComponent, canActivate: [GuestGuard] },
  { path: MY_PROFILE_PATH, component: PatientProfileSettingsComponent, canActivate: [AdminGuard] },
  { path: PROFILES_PATH_PARAMS, component: PatientProfilePageComponent, canActivate: [GuestGuard] },
  { path: ADMIN_USERS_PATH, component: PatientProfilePageComponent, canActivate: [AdminGuard] },
  {
    path: 'HomepageCA',
    component: ClinicAdminHomePageComponent,
    canActivate: [AdminGuard]
  },
  {
    path: '403',
    component: ForbiddenComponent
  },
  {
    path: '**',
    redirectTo: '/404'
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
  providers: []
})
export class AppRoutingModule { }
