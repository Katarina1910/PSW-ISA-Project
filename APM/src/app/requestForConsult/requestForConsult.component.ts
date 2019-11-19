import { Component } from '@angular/core';
import { RequestForConsult } from './requestForConsult';
import { RequestForConsultService } from './requestForConsult.service';

@Component({
    selector : 'cc-rqForConsult',
    templateUrl : './requestForConsult.component.html'
})
export class RequestForConsultComponent{
    requestForConsultModel = new RequestForConsult('',new Date());
    
    constructor(private _reqForConsultService: RequestForConsultService) {}

    onSubmit(){
        this._reqForConsultService.addRequestForConsult(this.requestForConsultModel)
       .subscribe(
           data=> console.log('Success!', data),
            error=> console.error('Error!',error)
        )
    }
}