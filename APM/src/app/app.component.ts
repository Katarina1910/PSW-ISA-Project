import { Component } from '@angular/core';
import { User } from './registration/user';

@Component({
  selector: 'pm-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  pageTitle: string = 'Clinical Center App';
  u:User = JSON.parse(localStorage.getItem("user")) as User;
   satm:String = this.u.getUserName();
}
