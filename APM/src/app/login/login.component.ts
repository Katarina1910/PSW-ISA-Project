import { Component, OnInit } from '@angular/core'
import { ActivatedRoute, Router } from '@angular/router'

@Component({
    selector: 'pm-login',
    templateUrl: './login.component.html'
  })

export class LoginPatientComponent {
  
  constructor(private _route: ActivatedRoute, 
              private _router: Router) { }
  
  onBack(): void {
    this._router.navigate(['/loginPatient'])
  }

}
