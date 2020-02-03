import { Component, OnInit } from '@angular/core';
import { ConsultTerm } from '../consultTerm/consultTerm';
import { ConsultTermService } from '../consultTerm/consultTerm.service';
import { listOfClinicsPat } from '../patientHomePage/listOfClinicsPat';
import { listOfClinicsPatService } from '../patientHomePage/listOfClinicsPat.service';
import { requestExamination } from './requestExamination.service';
import { UserService } from '../registration/user.service';
import { User } from '../registration/user';

@Component({
    selector: 'requestExamination-hp',
    templateUrl: './requestExamination.component.html'
})

export class RequestExamination implements OnInit{

    public consultTerms: ConsultTerm[];
    consultTermModel = new ConsultTerm(null,null,null,null,null,null,null,null,null);
    user: User = new User("","","","","","","","","","","","");
    private userId: number;

    constructor(private _consultTermService: ConsultTermService,
                private _requestExaminationService: requestExamination,
                private userService: UserService) {}

    ngOnInit(): void {
        this.getUserInfo();
        this._consultTermService.getConsultTermsInfo().subscribe(
            data=> {
                this.consultTerms = data;
                console.log(this.consultTerms)
            }, error => {
                console.log("Error in getting consult term data!")
            });
    }

    scheduleExamination(ct: ConsultTerm): void {
        this.consultTermModel = ct;
        this._requestExaminationService.appointExamination(this.consultTermModel, this.user.id).subscribe(
            data=> {
                console.log('Success!', JSON.stringify(data));
            }, error => {
                console.log("Error in appointing examination");
            }
        )
        alert("Examination has been scheduled!")
    }

    getUserInfo(): void {
        this.userService.getUserInfo().subscribe(data => {
          this.user = data;
        }, error => {
          console.log("Error in getting user data!")
        });
    }
}