import { Component } from '@angular/core';
import { User } from './user';
import { UserService } from './user.service';

@Component({
    selector : 'cc-registration',
    templateUrl : './registration.component.html'
})
export class RegistrationComponent{
    userModel = new User("hi"," "," "," "," "," "," "," "," "," "," ");
    
    constructor(private _userService: UserService) {}

    onSubmit(){
        this._userService.enroll(this.userModel)
        .subscribe(
            data=> console.log('Success!', data),
            error=> console.error('Error!',error)
        )
    }
}

