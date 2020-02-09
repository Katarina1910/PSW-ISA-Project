import { OnInit, Component, Input } from '@angular/core';
import { User } from '../registration/user';
import { MedicalRecordd } from '../medicalRecord/medicalRecord';
import { UserService } from '../registration/user.service';
import { MedicalRecordService } from '../medicalRecord/medicalRecord.service';

@Component({
    selector: 'patmed-rec',
    templateUrl: './patientMC.component.html'
})

export class PatientMC implements OnInit{

    user: User;
    medicalRecord = new MedicalRecordd(null, '','','','','','');

    constructor(private userService: UserService,
                private medicalRecordService: MedicalRecordService) { 
      }

    ngOnInit() {
        this.userService.getUserInfo().subscribe(data => {
            this.user = data;
            this.medicalRecordService.getMedicalRecordById(this.user.id).subscribe(
                data => {
                    this.medicalRecord = data;
                    console.log(this.medicalRecord);
                }, error => {
                    console.log("Error in getting medical record");
                }
            )
          }, error => {
            console.log("Error in getting user data!")
          });
    }

}