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
import { $ } from 'protractor';

@Component({
  selector: 'app-root',
  templateUrl: './doctorWorkCal.component.html',
})
export class DoctorWorkCalendar implements OnInit {
    
  showModal: boolean;
  room: string='room1';
  date: string="date";
  patient: string="patient";
  public consults: ConsultTerm[];
  public  events =[];
  user: User = new User("","","","","","","","","","","","");
  

  constructor(private _doctorWorkCalService: DoctorWorkCalService, private _userService:UserService, private router: Router) {}
  
  ngOnInit() {
    this.getUserInfo();
    this.events = [];
    this._doctorWorkCalService.getConsults(parseInt(localStorage.getItem('user-id')), localStorage.getItem('user-role')).subscribe(
      data=>{
        
        this.consults = data;
        
      },
      error=> console.error('Error!', error)
    )
     
    this.getEvents();
    
  }

  
  calendarPlugins = [dayGridPlugin, timGridPlugin, interactionPlugin, listPlugin];

  private getUserInfo(): void {
    this._userService.getUserInfo().subscribe(data => {
      this.user = data;     
    }, error => {
      console.log("Error in getting user data!")
    });
  }

  private eventClick(): void{
      this.showModal = true;
  }

  private close(): void{
    this.showModal = false;
}

  private getEvents() : void{
    this.events.push({
      start: '2020-02-10',
      title: 'Examination',
      allDay: false
    });
  }
}
