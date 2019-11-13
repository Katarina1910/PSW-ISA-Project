import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { LoginPatientComponent } from './login/login.component';
import { RouterModule } from '@angular/router';

@NgModule({
  declarations: [
    AppComponent,
    LoginPatientComponent,
  ],
  imports: [
    BrowserModule,
    RouterModule.forRoot([
      { path: 'loginPatient', component: LoginPatientComponent },
      { path: '', redirectTo: 'welcome', pathMatch: 'full' },
      { path: '**', redirectTo: 'welcome', pathMatch: 'full' }
    ], {useHash: true})
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }

