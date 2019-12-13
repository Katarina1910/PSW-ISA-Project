import { Component } from '@angular/core';
import { Login } from './login';
import { LoginService } from './login.service';
import { User } from '../registration/user';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { USER_ID_KEY, USER_ROLE_KEY, USERNAME_KEY, USER_TOKEN_KEY } from '../config/local-storage-keys';

@Component({
    selector : 'cc-login',
    templateUrl : './login.component.html'
})
export class LoginComponent{
    loginModel = new Login('','');
    u:User = null;
    loginForm: FormGroup;
    submitted = false;


    constructor(private _loginService: LoginService, private formBuilder: FormBuilder, private router: Router){ }

    ngOnInit() {
        this.loginForm = this.formBuilder.group({
            username: ['', Validators.required],
            password: ['', [Validators.required, Validators.minLength(3)]],
        });
    }
    get f() { return this.loginForm.controls; }
    
    onClickLogin(){
        this._loginService.login(this.loginModel)
       .subscribe(
        data => {
            this.u = data as User;
            sessionStorage.setItem("user",JSON.stringify(this.u));
            data = data as User;        
            console.log(data);
            
            localStorage.setItem(USER_ID_KEY, data.id);
            //localStorage.setItem(USER_ROLE_KEY, data.authorities[0]);
            localStorage.setItem(USERNAME_KEY, data.username);
            localStorage.setItem(USER_TOKEN_KEY, data.token.accessToken);
            localStorage.setItem(USER_ROLE_KEY, data.role)
            
            alert("Loged in!");
            this.router.navigate(['/welcome']);
        },
        error=> alert("Wrong password or username")
        );
        this.submitted = true;
    }
}