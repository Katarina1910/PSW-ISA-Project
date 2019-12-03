import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { Clinic } from './clinic';
import { AddNewClinicService } from './addNewClinic.service';


@Component({
    selector: 'cca-addnewclinic',
    templateUrl: './addNewClinic.component.html'
})

export class AddNewClinic{

    clinicModel = new Clinic('','','', 0.0, 0);

    constructor(private _addNewClinicService: AddNewClinicService, private router: Router){}

    onSubmit(){

        this._addNewClinicService.addNewClinic(this.clinicModel)
        .subscribe(
            data => {
                console.log('Success!', JSON.stringify(data))
                alert('Clinic added!');
                this.router.navigate(['/HomepageCCA']);
            },
            error => console.error('Error!', error)
        )
    }

}