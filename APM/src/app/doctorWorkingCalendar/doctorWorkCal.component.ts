import { Component, OnInit } from '@angular/core';
import dayGridPlugin from '@fullcalendar/daygrid';
import timGridPlugin from '@fullcalendar/timegrid';
import interactionPlugin from '@fullcalendar/interaction';
import listPlugin from '@fullcalendar/list';
import { Router } from '@angular/router';
import { DoctorWorkCalService } from './doctorWorkCal.service';
import { ConsultTerm } from '../consultTerm/consultTerm';
import { UserService } from '../registration/user.service';
import { User } from '../registration/user';

@Component({
  selector: 'app-root',
  templateUrl: './doctorWorkCal.component.html',
})
export class DoctorWorkCalendar implements OnInit {
    
  public consults: ConsultTerm[];
  user: User = new User("","","","","","","","","","","","");

  constructor(private _doctorWorkCalService: DoctorWorkCalService, private _userService:UserService, private router: Router) {}
  
  ngOnInit() {
    this.getUserInfo();
    this._doctorWorkCalService.getConsults(parseInt("4"), "ROLE_DOCTOR").subscribe(
      data=>{
        
        this.consults = data;
        for(var c of this.consults){
          console.log(JSON.stringify(c));
      }

      },
      error=> console.error('Error!', error)
    )
  }

  events = [
      {
            title:'Examination',
            start: '2020-02-10',
            allDay: false
      }
    ];

  calendarPlugins = [dayGridPlugin, timGridPlugin, interactionPlugin, listPlugin];

  private getUserInfo(): void {
    this._userService.getUserInfo().subscribe(data => {
      this.user = data;     
    }, error => {
      console.log("Error in getting user data!")
    });
  }

}