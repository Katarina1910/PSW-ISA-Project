import { Component } from '@angular/core';
import { ConsultTerm } from './consultTerm';
import { ConsultTermService } from './consultTerm.service';

@Component({
    selector : 'cc-consultTerm',
    templateUrl : './consultTerm.component.html'
})
export class ConsultTermComponent{
    consultTermModel = new ConsultTerm('','','','','');
    
    constructor(private _consultTermService: ConsultTermService) {}

    onSubmit(){
        this._consultTermService.addConsultTerm(this.consultTermModel)
       .subscribe(
           data=> console.log('Success!', data),
            error=> console.error('Error!',error)
        )
    }
}