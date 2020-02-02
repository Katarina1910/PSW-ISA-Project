import { Component } from '@angular/core';
import dayGridPlugin from '@fullcalendar/daygrid';
import timGridPlugin from '@fullcalendar/timegrid';
import interactionPlugin from '@fullcalendar/interaction';
import listPlugin from '@fullcalendar/list';

@Component({
  selector: 'app-root',
  templateUrl: './doctorWorkCal.component.html',
})
export class DoctorWorkCalendar {

  events = [
      {
            title:'Examination',
            start: '2020-02-10',
            allDay: false
      }
    ];

  calendarPlugins = [dayGridPlugin, timGridPlugin, interactionPlugin, listPlugin];

}