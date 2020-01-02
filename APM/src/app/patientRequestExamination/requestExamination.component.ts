import { Component, OnInit } from '@angular/core';
import { ConsultTerm } from '../consultTerm/consultTerm';
import { ConsultTermService } from '../consultTerm/consultTerm.service';
import { listOfClinicsPat } from '../patientHomePage/listOfClinicsPat';
import { listOfClinicsPatService } from '../patientHomePage/listOfClinicsPat.service';

@Component({
    selector: 'requestExamination-hp',
    templateUrl: './requestExamination.component.html'
})

export class RequestExamination implements OnInit{

    public consultTerms: ConsultTerm[];
    consultTermModel = new ConsultTerm(null,null,null,null,null,null,null,null);

    constructor(private _consultTermService: ConsultTermService, private _listOfClinicsService: listOfClinicsPatService) {}

    ngOnInit(): void {
        this._consultTermService.getConsultTermsInfo().subscribe(
            data=> {
                this.consultTerms = data;
                console.log(this.consultTerms)
            }, error => {
                console.log("Error in getting consult term data!")
            });
    }

    scheduleExamination(id: any): void {
        alert("Examination has been scheduled!")
    }
}