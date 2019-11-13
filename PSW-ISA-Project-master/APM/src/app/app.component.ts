import { Component } from '@angular/core';
import { RegistrationService } from './registration/registration.service';
import { RegistrationComponent } from './registration/registration.component';

@Component({
  selector: 'pm-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
  providers: [RegistrationService]
})
export class AppComponent {
  pageTitle: string = 'Clinical Center App';

}
