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
import { ConsultTermReportService } from '../ConsultTermReport/consultTermReport.service';

@Component({
  selector: 'app-root',
  templateUrl: './doctorWorkCal.component.html',
})
export class DoctorWorkCalendar implements OnInit {
    
  showModal: boolean;
  room: string='room1';
  date: string="date";
  id: number=1;
  patient: string="patient";
  public consults: ConsultTerm[];
  public  events:any[] = [];

  user: User = new User("","","","","","","","","","","","");
  

  constructor(private _doctorWorkCalService: DoctorWorkCalService,
    private consultTermReport: ConsultTermReportService,
     private _userService:UserService, private router: Router) {}
  
  ngOnInit() {
    this.getUserInfo();
    this.events = [];
    this._doctorWorkCalService.getConsults(parseInt(localStorage.getItem('user-id')), localStorage.getItem('user-role')).subscribe(
      data=>{
        this.consults = data;
      },
      error=> console.error('Error!', error)
    )    
    this.events.push({
      start: '2020-02-10',
      title: 'Examination',
      allDay: false
    });
  }

  
  calendarPlugins = [dayGridPlugin, timGridPlugin, interactionPlugin, listPlugin];

  private getUserInfo(): void {
    this._userService.getUserInfo().subscribe(data => {
      this.user = data;     
    }, error => {
      console.log("Error in getting user data!")
    });
  }

  private eventClick(event): void{
      //this.date = event.info.start;
      this.id = 2;
      this.showModal = true;
  }

  private close(): void{
    this.showModal = false;
}

  private getEvents() : void{
    console.log(this.consults);
    console.log(this.events);
    this.events.push({
      start: '2020-02-10',
      title: 'Examination',
      allDay: false
    });
    for(let i=0; i<this.consults.length; i++){
      
    } 
  }

  private startConsultTerm(id: string): void{
    this.consultTermReport.id = id;
    this.router.navigate(['/HomepageDoctor/consultTermReport']);
  }
}
