import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AddClinicAdminService } from './addNewClinicAdministrator.service';
import { Clinic } from '../addNewClinic/clinic';
import { ClinicAdmin } from './ClinicAdmin';


@Component({
    selector: 'cca-addnewCA',
    templateUrl: './addNewClinicAdministrator.component.html'
})

export class AddClinicAdminComponent implements OnInit{
    adminModel = new ClinicAdmin('','','','','','','','','','','');
    public clinics : Clinic[];
    
    constructor(private _addClinicAdminService: AddClinicAdminService,  private router: Router) {}

    ngOnInit(): void {
        this._addClinicAdminService.getClinics().subscribe(
            data=>{ 
                this.clinics = data;
            },
            error=> console.error('Error!', error)
        )
    }

    onSubmit(){
        this._addClinicAdminService.addClinicAdmin(this.adminModel)
       .subscribe(
           data=>{
            console.log('Success!', JSON.stringify(data))
            alert('Clinic Administrator added!');
            this.router.navigate(['/HomepageCA']);
           } ,
            error=> console.error('Error!',error)
        )
    }

}