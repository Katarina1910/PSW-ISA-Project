import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ConsultType } from 'src/consultType/consultType';
import { ConsultTypeService } from './consultType.service';


@Component({
    selector : 'cc-consultType',
    templateUrl : './consultType.component.html'
})
export class ConsultTypeComponent{

    consultTypeModel = new ConsultType(null,null);
    
    constructor(private _consultTypeService: ConsultTypeService, private router:Router) {}

    onSubmit(){
        this._consultTypeService.addConsultType(this.consultTypeModel)
       .subscribe(
           data=> {
               alert('Success!');
               this.router.navigate(['/HomepageCA']);
               console.log('Success!', JSON.stringify(data));
               
           },
            error=> console.error('Error!',error)
        )
    }
}