import { Component, OnInit } from '@angular/core';
import { listOfClinics } from './listOfClinics';
import { listOfClinicsService } from './listOfClinics.service';


@Component({
    selector: 'cc-listOfClinics',
    templateUrl: './listOfClinics.component.html'
})

export class ListOfClinics implements OnInit{

    public listClin : listOfClinics[];
    constructor(private _listOfClinicsService: listOfClinicsService) {}

    ngOnInit(){
        this._listOfClinicsService.getListOfClinics().subscribe(
            data=>{
                this.listClin = data;
            },
            error=>console.error('Error!',error)
        )
    }

}