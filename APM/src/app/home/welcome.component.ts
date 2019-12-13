import { Component } from '@angular/core';
import { UserService } from '../registration/user.service';
import { Router } from '@angular/router';

@Component({
  templateUrl: './welcome.component.html'
})
export class WelcomeComponent {
  public pageTitle = 'Welcome';

  constructor(private userService: UserService, private router: Router) { 
}

  isUserLoggedIn(): boolean {
    return this.userService.isUserLoggedIn();
  }
}
