import { Component } from '@angular/core';
import { User } from './user';
import { UserService } from './user.service';

@Component({
    selector : 'cc-registration',
    templateUrl : './registration.component.html'
})
export class RegistrationComponent{
    userModel = new User(""," "," "," "," "," "," "," "," "," ","");
    
    constructor(private _userService: UserService) {}

    onSubmit(){
        this._userService.enroll(this.userModel)
        .subscribe(
            data=>{ console.log('Success!', data);
                 alert("Registration request has been sent!")},
            error=> console.error('Error!',error)
        )
    }
}

