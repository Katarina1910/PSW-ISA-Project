import { Component } from '@angular/core';
import { USER_ID_KEY, USER_ROLE_KEY, USERNAME_KEY, USER_TOKEN_KEY } from './config/local-storage-keys';
import { UserService } from './registration/user.service';

@Component({
  selector: 'pm-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
})
export class AppComponent {
  pageTitle: string = 'Clinical Center App';

  constructor(private _userService: UserService) {}

  onClickLogout(): void {
    localStorage.removeItem(USER_ID_KEY);
    localStorage.removeItem(USER_ROLE_KEY);
    localStorage.removeItem(USERNAME_KEY);
    localStorage.removeItem(USER_TOKEN_KEY);
    alert('Logged out!');
  }
  
  isUserLoggedIn(): boolean {
    return this._userService.isUserLoggedIn();
  }

  isUserPatient(): boolean {
    return this._userService.isUserPatient();
  }

  isUserDoctor(): boolean {
  return this._userService.isUserDoctor();
  }

  isUserNurse(): boolean{
  return this._userService.isUserNurse();
  }

  isUserAdminCA(): boolean {
  return this._userService.isUserCA();
  }

  isUserAdminCCA(): boolean {
  return this._userService.isUserCCA();
  }
}
