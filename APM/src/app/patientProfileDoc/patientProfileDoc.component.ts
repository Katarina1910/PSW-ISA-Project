import { Component, OnInit } from '@angular/core';
import { User } from '../registration/user';
import { Router } from '@angular/router';
import { PatientProfileDocService } from './patientProfileDoc.service';
import { listOfPatientsDoctor } from '../doctorHomePage/listOfPatients.component';
import { listOfPatientsService } from '../doctorHomePage/listOfPatients.service';


@Component({
  selector: 'app-patient-profile-doc',
  templateUrl: './patientProfileDoc.component.html',
})
export class PatientProfileDocComponent  implements OnInit {

  user: User = new User("","","","","","","","","","","","");
  ngOnInit(): void {
   this.getProfile();
  }   

  

  constructor(private patientProfileDoc: listOfPatientsService, private router: Router) { 
  }


  

  getProfile(): void{
     this.user = this.patientProfileDoc.user;
  }


}
