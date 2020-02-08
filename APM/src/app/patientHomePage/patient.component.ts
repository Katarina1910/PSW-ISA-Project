import { Component, OnInit, Input } from '@angular/core';
import { UserService } from '../registration/user.service';
import { User } from '../registration/user';
import { Router } from '@angular/router';
import { listOfPatientsService } from '../doctorHomePage/listOfPatients.service';
import { PatientProfileDocService } from '../patientProfileDoc/patientProfileDoc.service';

@Component({
    selector: 'patient-hp',
    templateUrl: './patient.component.html'
})

export class PatientComponent implements OnInit{

    @Input() childUser: User;

    constructor(private _loginService: UserService){}

    ngOnInit(): void {
        this._loginService.getUserInfo().subscribe({next: data=>{
            this.childUser=data;
            console.log(data);}
        })
    }

}