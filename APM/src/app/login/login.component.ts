import { Component } from '@angular/core';
import { Login } from './login';
import { LoginService } from './login.service';

@Component({
    selector : 'cc-login',
    templateUrl : './login.component.html'
})
export class LoginComponent{
    loginModel = new Login(' ',' ');

    constructor(private _loginService: LoginService){ }

    //ovo nije dobro
    onSubmit(){
        this._loginService.login(this.loginModel)
       .subscribe(
        data => console.log('Success!', data),
        error=> console.error('Error!',error)
        );
    }
}