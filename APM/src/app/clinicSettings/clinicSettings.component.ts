import { Component, OnInit } from '@angular/core';
import { User } from '../registration/user';
import { UserService } from '../registration/user.service';
import { Router } from '@angular/router';
import { Clinic } from '../addNewClinic/clinic';
import { ClinicSettingsService } from './clinicSettings.service';
import { Doctor } from '../doctor/doctor';
import { DeleteDoctorService } from '../doctor/deleteDoctor.service';


@Component({
  selector: 'app-profile-settings',
  templateUrl: './clinicSettings.component.html',

})
export class ClinicSettingsComponent implements OnInit {

  
  user: User = new User("","","","","","","","","","","","");
  clinic: Clinic = new Clinic(null,null,null,null,null)  
  doctors: Doctor[];


  password: string = '';
  repeatPassword: string = '';

  constructor(private userService: UserService, private router: Router,
              private ccService: ClinicSettingsService, private deleteDocSevice : DeleteDoctorService) { 
  }

  ngOnInit() {
    this.getUserInfo();
    this.deleteDocSevice.getDoctors().subscribe(
      data=>{
        this.doctors = data;
        console.log(this.doctors)
      }
    )
  }

  onClickCancel(){
    this.router.navigate(['/HomepageCA']);
    
  }

  onClickSave(){
    console.log('Print: ', this.clinic)
        this.ccService.editClinic(this.clinic)
        .subscribe(
            data=> {
                alert('Request has been sent!')
                //this.router.navigate(['/HomepagePatient']);
            
                console.log('Updated!', JSON.stringify(data))
            },
            error=> console.error('Error updating!',error)
        )
  }

  private getUserInfo(): void {
    this.userService.getUserInfo().subscribe(data => {
      this.user = data;
      this.ccService.user = data;
      this.ccService.id = data.id;
      console.log( this.ccService.user)
      this.ccService.getClinic().subscribe( data => {
          this.clinic = data;
          console.log( this.clinic)
      }
        )
    }, error => {
      console.log("Error in getting user data!")
    });
  }
}
