import { Component, OnInit } from '@angular/core';
import { User } from '../registration/user';
import { UserService } from '../registration/user.service';
import { Router } from '@angular/router';
import { PatientProfileSettingsService } from './patientProfileSettings.service';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { AuthService } from '../service';
import { DisplayMessage } from '../shared/models/display-message';

@Component({
  selector: 'app-profile-settings',
  templateUrl: './patientProfileSettings.component.html',
  styleUrls: ['./patientProfileSettings.component.css']
})
export class PatientProfileSettingsComponent implements OnInit {

  user: User = new User("","","","","","","","","","","","","");
  form: FormGroup;
  notification: DisplayMessage;

  constructor(private userService: UserService, private router: Router,
              private editUserService: PatientProfileSettingsService,
              private formBuilder: FormBuilder,
              private authService: AuthService) { 
  }

  ngOnInit() {
    this.getUserInfo();
    this.form = this.formBuilder.group({
      oldPassword: ['', Validators.compose([Validators.required, Validators.minLength(3), Validators.maxLength(32)])],
      newPassword: ['', Validators.compose([Validators.required, Validators.minLength(3), Validators.maxLength(32)])],
      email: String
    });
  }

  onClickCancel(){
    if(this.userService.isUserCCA())
      this.router.navigate(['/HomepageCCA']);
    else if(this.userService.isUserCA())
      this.router.navigate(['/HomepageCA']);
    else if(this.userService.isUserDoctor())
      this.router.navigate(['/HomepageDoctor']);
    else if(this.userService.isUserNurse())
      this.router.navigate(['/HomepageNurse']);
    else if(this.userService.isUserPatient())
      this.router.navigate(['/HomepagePatient()']);
    else
      this.router.navigate(['/welcome']);
  }

  onClickSave(){
    this.editUserService.editUsers(this.user)
    .subscribe(
      data=> {
        alert('Request has been sent!');
        if(this.userService.isUserCCA())
          this.router.navigate(['/HomepageCCA']);
        else if(this.userService.isUserCA())
          this.router.navigate(['/HomepageCA']);
        else if(this.userService.isUserDoctor())
          this.router.navigate(['/HomepageDoctor']);
        else if(this.userService.isUserNurse())
          this.router.navigate(['/HomepageNurse']);
        else if(this.userService.isUserPatient())
          this.router.navigate(['/HomepagePatient()']);
        else
          this.router.navigate(['/welcome']);
          console.log('Updated!', JSON.stringify(data));
        },
        error=> console.error('Error updating!',error)
    )
      
  }

  onClickChangePassword() {
    console.log('Print: ', this.form.value);
    this.form.value.email = this.user.email;
    this.authService.changePassowrd(this.form.value)
    .subscribe(() => {
      this.authService.logout()
      this.router.navigate(['/login', {msgType: 'success', msgBody: 'Success! Please sign in with your new password.'}]);
    }, error => {
      this.notification = {msgType: 'error', msgBody: 'Invalid old password.'};
    });
    
  }

  private getUserInfo(): void {
    this.userService.getUserInfo().subscribe(data => {
      this.user = data;
    }, error => {
      console.log("Error in getting user data!")
    });
  }
}
