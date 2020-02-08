import { Component, OnInit } from '@angular/core';
import { User } from '../registration/user';
import { Router } from '@angular/router';
import { MedicalRecordd } from './medicalRecord';
import { MedicalRecordService } from './medicalRecord.service';
import { listOfPatientsService } from '../doctorHomePage/listOfPatients.service';
import { PatientProfileDocService } from '../patientProfileDoc/patientProfileDoc.service';

@Component({
    selector: 'med-rec',
    templateUrl: './medicalRecord.component.html'
})

export class MedicalRecord implements OnInit{

    user: User = new User("","","","","","","","","","","","");


    medicalRecord = new MedicalRecordd(null, '','','','','','');

    constructor(private router: Router, private medicalRecordService: MedicalRecordService,
      private patientProfileDoc: PatientProfileDocService,
       private _listOfPatientService: listOfPatientsService  ) { 
    }

  ngOnInit(): void {
    this.getProfile();
    this.medicalRecordService.getMedicalRecord()
     .subscribe(
         data => {
            console.log('Success!', JSON.stringify(data))
            this.medicalRecord = data;
            this.router.navigate(['/HomepageDoctor/ListOfPatients/Profile/MedicalRecord']);
         },
         error => console.error('Error!',error)
     )
  } 

  getProfile(): void{
    this.user = this.medicalRecordService.user;
 }


 Edit():void{
   this.medicalRecordService.editMedicalRecord(this.medicalRecord).subscribe(
      data =>{
            alert('Medical record successufully edited');
            this.router.navigate(['/HomepageDoctor/ListOfPatients/Profile']);
      },
      error =>{
        alert("Medical record has not been edited");
      }
   )
  
 }
}
