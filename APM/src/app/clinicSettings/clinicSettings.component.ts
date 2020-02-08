import { Component, OnInit, NgZone, ElementRef, ViewChild } from '@angular/core';
import { User } from '../registration/user';
import { UserService } from '../registration/user.service';
import { Router } from '@angular/router';
import { Clinic } from '../addNewClinic/clinic';
import { ClinicSettingsService } from './clinicSettings.service';
import { MapsAPILoader } from '@agm/core';
import { Doctor } from '../doctor/doctor';
import { DeleteDoctorService } from '../doctor/deleteDoctor.service';
import { FormControl } from '@angular/forms';


@Component({
  selector: 'app-profile-settings',
  templateUrl: './clinicSettings.component.html',
  styles: [`
  agm-map {
    height: 300px;
    width: 700px;
  }
`],

})
export class ClinicSettingsComponent implements OnInit {

  latitude: number = 45.267136;
  longitude: number = 19.833549;
  zoom:number = 15;
  address: string;
  private geoCoder;
 google: any;
 public searchControl: FormControl;
  
  user: User = new User("","","","","","","","","","","","");
  clinic: Clinic = new Clinic(null,null,null,null,null, null);
  doctors: Doctor[];


  password: string = '';
  repeatPassword: string = '';

  @ViewChild('search',null)
  public searchElementRef: ElementRef;

  constructor(private userService: UserService, private router: Router,
              private ccService: ClinicSettingsService,private mapsAPILoader: MapsAPILoader,
              private ngZone: NgZone, private deleteDocSevice : DeleteDoctorService) { 
  }

  ngOnInit() {
    this.getUserInfo();

    this.deleteDocSevice.getDoctors().subscribe(
      data=>{
        this.doctors = data;
        console.log(this.doctors)
      }
    )
    
    this.setCurrentLocation();
  }
  
  // Get Current Location Coordinates
  private setCurrentLocation() {
    if ('geolocation' in navigator) {
      navigator.geolocation.getCurrentPosition((position) => {
        this.ccService.getClinic().subscribe( data => {
          this.clinic = data;
          console.log(this.clinic.id)
        if(this.clinic.id == 1) {
          this.latitude = 44;
          this.longitude = 19;
          this.zoom = 12;
        } else if (this.clinic.id == 2) {
          this.latitude = 45;
          this.longitude = 20;
          this.zoom = 12;
        } else {
          this.latitude = position.coords.latitude;
          this.longitude = position.coords.longitude;
          this.zoom = 12;
        }
          }
            )
        }, error => {
          console.log("Error in getting user data!")
        });
        
    }
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
