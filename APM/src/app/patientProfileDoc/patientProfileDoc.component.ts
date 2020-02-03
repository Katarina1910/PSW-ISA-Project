import { Component, OnInit } from '@angular/core';
import { User } from '../registration/user';
import { Router } from '@angular/router';
import { PatientProfileDocService } from './patientProfileDoc.service';
import { listOfPatientsDoctor } from '../doctorHomePage/listOfPatients.component';
import { listOfPatientsService } from '../doctorHomePage/listOfPatients.service';
import { MedicalRecordService } from '../medicalRecord/medicalRecord.service';


@Component({
  selector: 'app-patient-profile-doc',
  templateUrl: './patientProfileDoc.component.html',
})
export class PatientProfileDocComponent  implements OnInit {

  user: User = new User("","","","","","","","","","","","");
  ngOnInit(): void {
   this.getProfile();
  }   

  constructor(private patientProfileDoc: listOfPatientsService, private router: Router, private medicalRecordService: MedicalRecordService) { 
  }

  getUserProfile(id:number): void{
    this.medicalRecordService.getUserProfile(id).subscribe(
        data=>{
            this.patientProfileDoc.user = data;
            this.router.navigate(['/HomepageDoctor/ListOfPatients/Profile/MedicalRecord']);
        },
        error=> console.error('Error!', error)
    )
   
  }
  
  getProfile(): void{
     this.user = this.patientProfileDoc.user;
  }


}
