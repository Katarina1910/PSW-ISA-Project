import { Component } from '@angular/core';
import { UserService } from '../registration/user.service';
import { Router } from '@angular/router';
import { User } from '../registration/user';

@Component({
  templateUrl: './welcome.component.html'
})
export class WelcomeComponent {
  public pageTitle = 'Welcome';

  user = JSON.parse(sessionStorage.getItem("user")) as User;

  constructor(private userService: UserService, private router: Router) { 
}

isUserPatient(): boolean {
    return this.userService.isUserPatient();
}


  isUserDoctor(): any {
    return this.userService.isUserDoctor();
  }
}


