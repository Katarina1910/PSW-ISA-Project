import { Component, OnInit } from '@angular/core';
import { User } from '../registration/user';
import { DeleteConsultTypeService } from '../consultType/deleteConsultType.service';
import { listOfClinicsPatService } from '../patientHomePage/listOfClinicsPat.service';
import { listOfPatientsService } from '../doctorHomePage/listOfPatients.service';
import { DoctorRequestForOperation } from './doctorRqForOperaton';
import { DoctorRequestForOperationService } from './doctorRqForOperaton.service';

@Component({
    selector : 'cc-rqForOPeration',
    templateUrl : './doctorRqForOperation.component.html'
})
export class DoctorRequestForOperationComponent implements OnInit {
    requestForConsultModel = new DoctorRequestForOperation(null,null,null,null);
    public patients: User[];
    datee : any = new Date().toISOString();

    ngOnInit(): void {
        const mySQLDateString = this.datee.slice(0, 10).replace('T', ' ');
        this.requestForConsultModel.dateAndTime = mySQLDateString
        this._listOfPatientsService.getListOgPatients().subscribe(
            data=> this.patients = data,
            error=> console.error('Error!', error)           
        )
    }
    
    constructor(private _docReqForOpService: DoctorRequestForOperationService,
          private _listOfPatientsService: listOfPatientsService) {}

    onSubmit(){
        console.log(this.requestForConsultModel)
        this._docReqForOpService.addRequestForOperation(this.requestForConsultModel)
       .subscribe(
           data=> console.log('Success!', data),
            error=> console.error('Error!',error)
        )
        
    }
}