import { Component } from '@angular/core';
import { Login } from './login';
import { LoginService } from './login.service';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
    selector : 'cc-login',
    templateUrl : './login.component.html'
})
export class LoginComponent{
    loginModel = new Login(' ',' ');

    loginForm: FormGroup;
    submitted = false;

    constructor(private _loginService: LoginService, private formBuilder: FormBuilder){ }

    ngOnInit() {
        this.loginForm = this.formBuilder.group({
            username: ['', Validators.required],
            password: ['', [Validators.required, Validators.minLength(6)]]
        });
    }

    // convenience getter for easy access to form fields
    get f() { return this.loginForm.controls; }

    //ovo nije dobro
    onSubmit(){
        this._loginService.login(this.loginModel)
       .subscribe(
        data => console.log('Success!', data),
        error=> console.error('Error!',error)
        );

        this.submitted = true;

        // stop here if form is invalid
        if (this.loginForm.invalid) {
            return;
        }

        alert('Logged in!')
    }
}