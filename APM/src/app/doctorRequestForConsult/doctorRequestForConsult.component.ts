import { Component, OnInit } from '@angular/core';
import { DoctorRequestForConsult } from './doctorRequestForConsult';
import { DoctorRequestForConsultService } from './doctorRequestForConsult.service';
import { ConsultType } from 'src/consultType/consultType';
import { User } from '../registration/user';
import { DeleteConsultTypeService } from '../consultType/deleteConsultType.service';
import { listOfClinicsPatService } from '../patientHomePage/listOfClinicsPat.service';
import { listOfPatientsService } from '../doctorHomePage/listOfPatients.service';
import { templateVisitAll } from '@angular/compiler';

@Component({
    selector : 'cc-rqForConsult',
    templateUrl : './doctorRequestForConsult.component.html'
})
export class DoctorRequestForConsultComponent implements OnInit {
    requestForConsultModel = new DoctorRequestForConsult(null,null,null,null,null);
    public types: ConsultType[];
    public patients: User[];
    datee : any = new Date().toISOString();

    ngOnInit(): void {
        const mySQLDateString = this.datee.slice(0, 10).replace('T', ' ');
        this.requestForConsultModel.dateAndTime = mySQLDateString
        console.log(this.datee)
        this._listOfPatientsService.getListOgPatients().subscribe(
            data=> this.patients = data,
            error=> console.error('Error!', error)           
        )

        this._deleteConsultTypeService.getConsultTypes().subscribe(
            data=>this.types = data,
            error=> console.error('Error!', error)
        )
    }
    
    constructor(private _docReqForConsultService: DoctorRequestForConsultService,
          private _listOfPatientsService: listOfPatientsService, private _deleteConsultTypeService: DeleteConsultTypeService) {}

    onSubmit(){
        console.log(this.requestForConsultModel)
        console.log(this.requestForConsultModel.type)
        this._docReqForConsultService.addRequestForConsult(this.requestForConsultModel)
       .subscribe(
           data=> console.log('Success!', data),
            error=> console.error('Error!',error)
        )
        
    }
}