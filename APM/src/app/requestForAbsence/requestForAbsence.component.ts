import { Component, OnInit } from '@angular/core';
import { RequestForAbsence } from './requestForAbsence';
import { RequestForAbsenceService } from './requestForAbsence.service';
import { UserService } from '../registration/user.service';
import { User } from '../registration/user';
import { Doctor } from '../doctor/doctor';



@Component({
    templateUrl: './requestForAbsence.component.html'
})

export class RequestForAbsenceComponent implements OnInit{
    
    user = new User(" "," "," "," "," "," "," "," "," "," "," ","");
    doctorModel = new Doctor(null,null,null);
    requestForAbsence = new RequestForAbsence (null,null,null,null, new Date(),new Date());
    
    constructor(private _reqForAbsenceService: RequestForAbsenceService, private _userService: UserService) {}

    onSubmit(){
        this._reqForAbsenceService.addRequestForAbsence(this.requestForAbsence)
       .subscribe(
           data=> console.log('Success!', data),
            error=> console.error('Error!',error)
        )
    }

    ngOnInit(): void {
      this._userService.getUserInfo().subscribe(
          data=>{
              this.doctorModel = data;
              console.log(data);
              this.requestForAbsence.applicant = this.doctorModel;
              console.log(this.requestForAbsence);
          }
      )
    }

}