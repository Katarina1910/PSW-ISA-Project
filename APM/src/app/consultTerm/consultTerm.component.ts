import { Component } from '@angular/core';
import { ConsultTerm } from './consultTerm';
import { ConsultTermService } from './consultTerm.service';
import { Router } from '@angular/router';

@Component({
    selector : 'cc-consultTerm',
    templateUrl : './consultTerm.component.html'
})
export class ConsultTermComponent{
    consultTermModel = new ConsultTerm('','','','','');
    
    constructor(private _consultTermService: ConsultTermService, private router:Router) {}

    onSubmit(){
        this._consultTermService.addConsultTerm(this.consultTermModel)
       .subscribe(
           data=> {
               alert('Success!');
               console.log('Success!', JSON.stringify(data));
               this.router.navigate(['/welcome']);
           },
            error=> console.error('Error!',error)
        )
    }
}