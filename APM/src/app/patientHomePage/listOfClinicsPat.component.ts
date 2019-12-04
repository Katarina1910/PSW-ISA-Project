import { Component, OnInit } from '@angular/core';
import { listOfClinicsPatService } from './listOfClinicsPat.service';
import { listOfClinicsPat } from './listOfClinicsPat';


@Component({
    selector: 'pat-listOfClinics',
    templateUrl: './listOfClinicsPat.component.html'
})

export class ListOfPatClinics implements OnInit{

    public listClin : listOfClinicsPat[];
    constructor(private _listOfClinicsService: listOfClinicsPatService) {}

    ngOnInit(){
        this._listOfClinicsService.getListOfClinics().subscribe(
            data=>{
                this.listClin = data;
            },
            error=>console.error('Error!',error)
        )
    }

}