import { Component } from '@angular/core';
import { Registration } from './registration';
import { RegistrationService } from './registration.service' 

@Component({
    selector : 'cc-registration',
    templateUrl : './registration.component.html'
})
export class RegistrationComponent{
    roles : string [] =  ['Patient' , 'Doctor', 'Nurse', 'Clinic Administrator', 'Clinical Center Administrator']
    userModel = new Registration(' ',' ',' ',' ',' ', ' ',' ',' ','user','user','');

    constructor(private _registrationService: RegistrationService) {}

    onSubmit() {
        this._registrationService.enroll(this.userModel)
        .subscribe(
            data => console.log('Success!',data),
           error=> console.error('Error!', error)
            
        )
    }
    
}