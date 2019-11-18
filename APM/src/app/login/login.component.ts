import { Component } from '@angular/core';
import { Login } from './login';
import { LoginService } from './login.service';
import { User } from '../registration/user';

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
        data => {
            alert("Loged in!");
            sessionStorage.setItem("user",data);
            data = data as User;
            alert("Wellcome!");
            
            console.log(data);
        },
        error=> alert("Wrong password or username")
        );
    }
}