import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { LoginPatientComponent } from './login/login.component';
import { RouterModule } from '@angular/router';
import { WelcomeComponent } from './home/welcome.component'

@NgModule({
  declarations: [
    AppComponent,
    LoginPatientComponent,
    WelcomeComponent,
  ],
  imports: [
    BrowserModule,
    RouterModule.forRoot([
      { path: 'loginPatient', component: LoginPatientComponent },
      { path: '', component: WelcomeComponent, pathMatch: 'full' },
      { path: '**', redirectTo: 'welcome', pathMatch: 'full' }
    ], {useHash: true})
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }

