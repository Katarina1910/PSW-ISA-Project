import { Component, OnInit } from '@angular/core';
import { User } from '../registration/user';
import { Router } from '@angular/router';
import { PatientProfileDocService } from './patientProfileDoc.service';
import { listOfPatientsDoctor } from '../doctorHomePage/listOfPatients.component';
import { listOfPatientsService } from '../doctorHomePage/listOfPatients.service';
import { MedicalRecordService } from '../medicalRecord/medicalRecord.service';
import { MedicalRecordd } from '../medicalRecord/medicalRecord';
import { Consult } from '../ConsultTermReport/Consult';


@Component({
  selector: 'app-patient-profile-doc',
  templateUrl: './patientProfileDoc.component.html',
})
export class PatientProfileDocComponent  implements OnInit {

  user: User = new User("","","","","","","","","","","","","",false);
  medicalRecord: MedicalRecordd;
  
  ngOnInit(): void {
      this.getProfile();
  }   

  constructor(private patientProfileDoc: listOfPatientsService, private patientProfileService: PatientProfileDocService, 
    private router: Router, private medicalRecordService: MedicalRecordService) { 
  }

  getUserProfile(id:number): void{
       this.router.navigate(['/HomepageDoctor/ListOfPatients/Profile/MedicalRecord']); 
  }
  
  getProfile(): void{
     this.user = this.patientProfileDoc.user;
     this.medicalRecordService.id = this.user.id;
  }


}
