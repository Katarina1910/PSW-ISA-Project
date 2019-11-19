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
    u:User = null;

    constructor(private _loginService: LoginService){ }

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
    }
}