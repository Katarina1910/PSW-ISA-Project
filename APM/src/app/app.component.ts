import { Component } from '@angular/core';
import { USER_ID_KEY, USER_ROLE_KEY, USERNAME_KEY, USER_TOKEN_KEY } from './config/local-storage-keys';

@Component({
  selector: 'pm-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  pageTitle: string = 'Clinical Center App';

  onClickLogout(): void {
    localStorage.removeItem(USER_ID_KEY);
    //localStorage.removeItem(USER_ROLE_KEY);
    localStorage.removeItem(USERNAME_KEY);
    localStorage.removeItem(USER_TOKEN_KEY);
    alert('Logged out!');
  }
 
}
