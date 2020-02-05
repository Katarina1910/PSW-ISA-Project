import { Component, OnInit } from '@angular/core';
import { User } from '../registration/user';
import { Router } from '@angular/router';
import { MedicalRecordd } from './medicalRecord';
import { MedicalRecordService } from './medicalRecord.service';

@Component({
    selector: 'med-rec',
    templateUrl: './medicalRecord.component.html'
})

export class MedicalRecord implements OnInit{

    user: User = new User("","","","","","","","","","","","");

    medicalRecord = new MedicalRecordd(null, '','','','','','');

    constructor(private router: Router, private medicalRecordService: MedicalRecordService) { 
    }

  ngOnInit(): void {
    this.getProfile();
    this.getUserProfile(1);
  } 

  getProfile(): void{
    this.user = this.medicalRecordService.user;
 }

 getUserProfile(id:any):void{
     this.medicalRecordService.getMedicalRecord(id)
     .subscribe(
         data => {
            console.log('Success!', JSON.stringify(data))
            this.medicalRecord = data;
            this.router.navigate(['/HomepageDoctor/ListOfPatients/Profile/MedicalRecord']);
         },
         error => console.error('Error!',error)
     )
 }

}
