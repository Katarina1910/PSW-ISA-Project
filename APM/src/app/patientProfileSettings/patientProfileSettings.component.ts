import { Component, OnInit } from '@angular/core';
import { User } from '../registration/user';
import { UserService } from '../registration/user.service';

@Component({
  selector: 'app-profile-settings',
  templateUrl: './patientProfileSettings.component.html',
  styleUrls: ['./patientProfileSettings.component.css']
})
export class PatientProfileSettingsComponent implements OnInit {

  user: User = new User("","","","","","","","","","","");

  password: string = '';
  repeatPassword: string = '';

  constructor(private userService: UserService) { 
  }

  ngOnInit() {
    this.getUserInfo();
  }

  private getUserInfo(): void {
    this.userService.getUserInfo().subscribe(data => {
      this.user = data;
    }, error => {
      console.log("Error!!")
    });
  }
}
