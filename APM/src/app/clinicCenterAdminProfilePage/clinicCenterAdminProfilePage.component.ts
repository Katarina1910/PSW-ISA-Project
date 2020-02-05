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

  user: User = new User("","","","","","","","","","","","");
  form: FormGroup;
  notification: DisplayMessage;

  constructor(private userService: UserService, private router: Router,
              private editUserService: ClinicCenterAdminProfilePageService,
              private formBuilder: FormBuilder,
              private authService: AuthService) { 
  }

  ngOnInit() {
    this.getUserInfo();
    this.form = this.formBuilder.group({
      oldPassword: ['', Validators.compose([Validators.required, Validators.minLength(3), Validators.maxLength(32)])],
      newPassword: ['', Validators.compose([Validators.required, Validators.minLength(3), Validators.maxLength(32)])]
    });
  }

  onClickCancel(){
    this.router.navigate(['/HomepageCCA']);
  }

  onClickSave(){
    console.log('Print: ', this.user)
    
    this.authService.changePassowrd(this.form.value)
    .subscribe(() => {
      this.authService.logout()
      this.router.navigate(['/login', {msgType: 'success', msgBody: 'Success! Please sign in with your new password.'}]);
    }, error => {
      this.notification = {msgType: 'error', msgBody: 'Invalid old password.'};
    });
    
    this.editUserService.editUsers(this.user)
    .subscribe(
      data=> {
        alert('Your data has been changed!')
        this.router.navigate(['/HomepageCCA']);    
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
