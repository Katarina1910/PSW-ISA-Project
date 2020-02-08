import { Component, OnInit } from '@angular/core';
import { User } from '../registration/user';
import { UserService } from '../registration/user.service';
import { Router } from '@angular/router';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { AuthService } from '../service';
import { DisplayMessage } from '../shared/models/display-message';
import { ClinicCenterAdminProfilePageService } from './clinicCenterAdminProfilePage.service';

@Component({
  selector: 'app-cca-profile',
  templateUrl: './clinicCenterAdminProfilePage.component.html'
})

export class ClinicCenterAdminProfilePageComponent implements OnInit {

  user: User = new User("","","","","","","","","","","","","");
  form: FormGroup;
  notification: DisplayMessage;

  constructor(private userService: UserService, private router: Router,
              private editUserService: ClinicCenterAdminProfilePageService,
              private formBuilder: FormBuilder,
              private authService: AuthService) { 
  }

  ngOnInit() {
    this.getUserInfo();
  }

  onClickCancel(){
    if(this.userService.isUserCA())
      this.router.navigate(['/HomepageCA']);
    else if(this.userService.isUserNurse()){
      this.router.navigate(['/HomepageNurse']);
    }
    else if(this.userService.isUserCCA()){
        this.router.navigate(['/HomepageCCA']);
      }
    }

  onClickSave(){
    this.editUserService.editUsers(this.user)
    .subscribe(
      data=> {
        alert('Your data has been changed!')
        if(this.userService.isUserCA())
          this.router.navigate(['/HomepageCA']);
        else if(this.userService.isUserNurse())
          this.router.navigate(['/HomepageNurse']);
        else if(this.userService.isUserCCA())
          this.router.navigate(['/HomepageCCA']);
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
