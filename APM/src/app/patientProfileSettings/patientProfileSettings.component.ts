import { Component, OnInit } from '@angular/core';
import { User } from '../registration/user';
import { UserService } from '../registration/user.service';
import { Router } from '@angular/router';
import { PatientProfileSettingsService } from './patientProfileSettings.service';

@Component({
  selector: 'app-profile-settings',
  templateUrl: './patientProfileSettings.component.html',
  styleUrls: ['./patientProfileSettings.component.css']
})
export class PatientProfileSettingsComponent implements OnInit {

  user: User = new User("","","","","","","","","","","");

  password: string = '';
  repeatPassword: string = '';

  constructor(private userService: UserService, private router: Router,
              private editUserService: PatientProfileSettingsService) { 
  }

  ngOnInit() {
    this.getUserInfo();
  }

  onClickCancel(){
    this.router.navigate(['/HomepagePatient']);
  }

  onClickSave(){
    console.log('Print: ', this.user)
        this.editUserService.editUsers(this.user)
        .subscribe(
            data=> {
                alert('Request has been sent!')
                this.router.navigate(['/HomepagePatient']);
            
                console.log('Updated!', JSON.stringify(data))
            },
            error=> console.error('Error updating!',error)
        )
  }

  private getUserInfo(): void {
    this.userService.getUserInfo().subscribe(data => {
      this.user = data;
    }, error => {
      console.log("Error in getting user data!")
    });
  }
}
