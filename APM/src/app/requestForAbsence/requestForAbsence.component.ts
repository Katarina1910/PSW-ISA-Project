import { Component, OnInit } from '@angular/core';
import { RequestForAbsence } from './requestForAbsence';
import { RequestForAbsenceService } from './requestForAbsence.service';
import { UserService } from '../registration/user.service';
import { User } from '../registration/user';



@Component({
    templateUrl: './requestForAbsence.component.html'
})

export class RequestForAbsenceComponent implements OnInit{
    
    user = new User(" "," "," "," "," "," "," "," "," "," "," ","");
    requestForAbsence = new RequestForAbsence (null,null,null,null, new Date(),new Date(),null);
    
    constructor(private _reqForAbsenceService: RequestForAbsenceService, private _userService: UserService) {}

    onSubmit(){
        this._reqForAbsenceService.addRequestForAbsence(this.requestForAbsence)
       .subscribe(
           data=> console.log('Success!', data),
            error=> console.error('Error!',error)
        )
    }

    ngOnInit(): void {
      
    }

}