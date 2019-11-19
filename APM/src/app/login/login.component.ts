import { Component } from '@angular/core';
import { Login } from './login';
import { LoginService } from './login.service';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { User } from '../registration/user';

@Component({
    selector : 'cc-login',
    templateUrl : './login.component.html'
})
export class LoginComponent{
    loginModel = new Login('','');

    loginForm: FormGroup;
    submitted = false;

    u:User = null;

    constructor(private _loginService: LoginService, private formBuilder: FormBuilder){ }

    ngOnInit() {
        this.loginForm = this.formBuilder.group({
            username: ['', Validators.required],
            password: ['', [Validators.required, Validators.minLength(6)]],
            password2: ['', [Validators.required, Validators.minLength(6)]]
        });
    }

    // convenience getter for easy access to form fields
    get f() { return this.loginForm.controls; }

    //ovo nije dobro
    onSubmit(){
        this._loginService.login(this.loginModel)
       .subscribe(
        data => {
            alert("Loged in!");
            this.u = data as User;
            sessionStorage.setItem("user",JSON.stringify(this.u));
            data = data as User;
            alert("Wellcome!");
            
            console.log(data);
        },
        error=> alert("Wrong password or username")
        );
        this.submitted = true;
    }
}