import { Component, OnInit } from '@angular/core';
import { User } from '../registration/user';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { DisplayMessage } from '../shared/models/display-message';
import { AuthService } from '../service';
import { Router } from '@angular/router';
import { UserService } from '../registration/user.service';

@Component({
    selector : 'cc-changePassword',
    templateUrl : './changePassword.html'
})

export class ChangePassword implements OnInit{

    user: User = new User("","","","","","","","","","","","","",false);
    form: FormGroup;
    notification: DisplayMessage;

    constructor(private router: Router,
                private formBuilder: FormBuilder,
                private authService: AuthService,
                private userService: UserService) { 
    }

    ngOnInit() {
        this.getUserInfo();
        this.form = this.formBuilder.group({
          oldPassword: ['', Validators.compose([Validators.required, Validators.minLength(3), Validators.maxLength(32)])],
          newPassword: ['', Validators.compose([Validators.required, Validators.minLength(3), Validators.maxLength(32)])],
          email: String
        });
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