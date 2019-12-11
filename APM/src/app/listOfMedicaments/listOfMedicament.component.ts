import { Component, OnInit } from '@angular/core';
import { listOfMedicamentService } from './listOfMedicament.service';
import { listOfMedicaments } from './listOfMedicament';


@Component({
    selector: 'cc-listOfMedicament',
    templateUrl: './listOfMedicament.component.html'
})

export class ListOfMedicament implements OnInit{

    public listMed : listOfMedicaments[];
    constructor(private _listOfMedicametService: listOfMedicamentService) {}

    ngOnInit(){
        this._listOfMedicametService.getListOfMedicament().subscribe(
            data=>{
                this.listMed = data;
            },
            error=>console.error('Error!',error)
        )
    }

}