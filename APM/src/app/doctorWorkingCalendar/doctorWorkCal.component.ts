import {Component, ChangeDetectionStrategy, ViewChild,TemplateRef, OnInit } from '@angular/core';
import {startOfDay, endOfDay, subDays, addDays, endOfMonth, isSameDay, isSameMonth, addHours} from 'date-fns';
import { Subject } from 'rxjs';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { CalendarEvent, CalendarEventAction, CalendarEventTimesChangedEvent, CalendarView} from 'angular-calendar';
import { DoctorWorkCalService } from './doctorWorkCal.service';
import { ConsultTerm } from '../consultTerm/consultTerm';
import { Router } from '@angular/router';
import { ConsultTermReportService } from '../ConsultTermReport/consultTermReport.service';

const colors: any = {
  red: {
    primary: '#ad2121',
    secondary: '#FAE3E3'
  },
  blue: {
    primary: '#1e90ff',
    secondary: '#D1E8FF'
  },
  yellow: {
    primary: '#e3bc08',
    secondary: '#FDF1BA'
  }
};

@Component({
  selector: 'doctor-work-cal',
  changeDetection: ChangeDetectionStrategy.OnPush,
  styleUrls: ['doctorWorkCal.component.css'],
  templateUrl: 'doctorWorkCal.component.html'
})
export class DoctorWorkCalendar  implements OnInit{

public consults: ConsultTerm[];
public consultTerm = new ConsultTerm(null,null,null,null,null,null,null,null,null,null,null);
public room: string;
showModal: boolean;
public patient: string;
public duration: string;
public start: string;
public id: string;

ngOnInit(): void {
  this._docWorkCalService.getConsults(parseInt(localStorage.getItem('user-id')), localStorage.getItem('user-role')).subscribe(
    data=>{
        this.consults = data;
        for(let i=0; i< this.consults.length; i++){
          this.events = [...this.events,{
              title : 'Consult',
              start : new Date(this.consults[i].date),
              id : this.consults[i].id,
              color: colors.red
          }];
        }      
    }, 
    error=>{
    }
  );
}

  @ViewChild('modalContent', { static: true }) modalContent: TemplateRef<any>;

  view: CalendarView = CalendarView.Month;

  CalendarView = CalendarView;

  viewDate: Date = new Date();

  modalData: {
    action: string;
    event: CalendarEvent;
  };

  actions: CalendarEventAction[] = [
    {
      label: '<i class="fa fa-fw fa-pencil"></i>',
      a11yLabel: 'Edit',
      onClick: ({ event }: { event: CalendarEvent }): void => {
        this.handleEvent('Edited', event);
      }
    },
    {
      label: '<i class="fa fa-fw fa-times"></i>',
      a11yLabel: 'Delete',
      onClick: ({ event }: { event: CalendarEvent }): void => {
        this.events = this.events.filter(iEvent => iEvent !== event);
        this.handleEvent('Deleted', event);
      }
    }
  ];

  refresh: Subject<any> = new Subject();

  events: CalendarEvent[] = [];

  activeDayIsOpen: boolean = true;

  constructor(private modal: NgbModal, private _docWorkCalService: DoctorWorkCalService, private router: Router,
              private _consultTermReportService: ConsultTermReportService) {}

  dayClicked({ date, events }: { date: Date; events: CalendarEvent[] }): void {
    if (isSameMonth(date, this.viewDate)) {
      if (
        (isSameDay(this.viewDate, date) && this.activeDayIsOpen === true) ||
        events.length === 0
      ) {
        this.activeDayIsOpen = false;
      } else {
        this.activeDayIsOpen = true;
      }
      this.viewDate = date;
    }
  }

  eventTimesChanged({
    event,
    newStart,
    newEnd
  }: CalendarEventTimesChangedEvent): void {
    this.events = this.events.map(iEvent => {
      if (iEvent === event) {
        return {
          ...event,
          start: newStart,
          end: newEnd
        };
      }
      return iEvent;
    });
    this.handleEvent('Dropped or resized', event);
    alert(1);
  }

  handleEvent(action: string, event: CalendarEvent): void {   
    this._docWorkCalService.getConsult(event.id.toString()).subscribe(
        data=>{
              this.consultTerm = data;
              this.id = data.id;
              this.duration = data.duration;
              this.start = data.date.toString();
              this.room =  data.room.name;
              this.patient = data.patient.name + " "+ data.patient.surname;
              this.showModal = true;
        },error =>{

        }
    );

  }

  private close(): void{
    this.showModal = false;
  }

  private startConsult(): void{
    this._consultTermReportService.id = this.id;
    this.router.navigate(['/HomepageDoctor/consultTermReport']);
  }

  setView(view: CalendarView) {
    this.view = view;
  }

  closeOpenMonthViewDay() {
    this.activeDayIsOpen = false;
  }

  

}
