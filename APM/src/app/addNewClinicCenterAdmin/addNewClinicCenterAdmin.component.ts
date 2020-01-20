import { Component,  } from '@angular/core';
import { ClinicCenterAdmin } from './ClinicCenterAdmin';
import { AddClinicCenterAdminService } from './addNewClinicCenterAdmin.service';
import { Router } from '@angular/router';


@Component({
    selector: 'cca-addnewCCA',
    templateUrl: './addNewClinicCenterAdmin.component.html'
})

export class addNewClinicCenterAdmin{

    adminModel = new ClinicCenterAdmin('','','','','','','','','','');

    constructor(private _addClinicCenterAdminService: AddClinicCenterAdminService, private router: Router){}


    onSubmit(){

        this._addClinicCenterAdminService.addNewClinicCenterAdmin(this.adminModel)
        .subscribe(
            data => {
                console.log('Success!', JSON.stringify(data))
                alert('Clinic Center Administrator added!');
                this.router.navigate(['/HomepageCCA']);
            },
            error => console.error('Error!', error)
        )
    }
    
}