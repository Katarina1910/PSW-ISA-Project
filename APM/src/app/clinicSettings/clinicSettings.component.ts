import { Component, OnInit, NgZone, ElementRef, ViewChild } from '@angular/core';
import { User } from '../registration/user';
import { UserService } from '../registration/user.service';
import { Router } from '@angular/router';
import { Clinic } from '../addNewClinic/clinic';
import { ClinicSettingsService } from './clinicSettings.service';
import { MapsAPILoader } from '@agm/core';
import { Doctor } from '../doctor/doctor';
import { DeleteDoctorService } from '../doctor/deleteDoctor.service';


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
  longitude: number = 29.833549;
  zoom:number = 15;
  address: string;
  private geoCoder;
 google: any;
  
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

    //load Places Autocomplete
    this.mapsAPILoader.load().then(() => {  
      this.setCurrentLocation();
      this.geoCoder = new google.maps.Geocoder;
 
      let autocomplete = new google.maps.places.Autocomplete(this.searchElementRef.nativeElement, {
        types: ["address"]
      });
      autocomplete.addListener("place_changed", () => {
        this.ngZone.run(() => {
          //get the place result
          let place: google.maps.places.PlaceResult = autocomplete.getPlace();
 
          //verify result
          if (place.geometry === undefined || place.geometry === null) {
            return;
          }
 
          //set latitude, longitude and zoom
          this.latitude = place.geometry.location.lat();
          this.longitude = place.geometry.location.lng();
          this.zoom = 12;
        });
      });
    });
  }
  
  // Get Current Location Coordinates
  private setCurrentLocation() {
    if ('geolocation' in navigator) {
      navigator.geolocation.getCurrentPosition((position) => {
        this.latitude = position.coords.latitude;
        this.longitude = position.coords.longitude;
        this.zoom = 8;
        this.getAddress(this.latitude, this.longitude);
      });
    }
  }
  
  getAddress(latitude, longitude) {
    this.geoCoder.geocode({ 'location': { lat: latitude, lng: longitude } }, (results, status) => {
      console.log(results);
      console.log(status);
      if (status === 'OK') {
        if (results[0]) {
          this.zoom = 12;
          this.address = results[0].formatted_address;
        } else {
          window.alert('No results found');
        }
      } else {
        window.alert('Geocoder failed due to: ' + status);
      }
 
    });

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
