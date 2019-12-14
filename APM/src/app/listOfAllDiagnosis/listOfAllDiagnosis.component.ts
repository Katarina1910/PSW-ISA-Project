import { Component, OnInit } from '@angular/core';
import { listOfDiagnosis } from './listOfAllDiagnosis';
import { listOfDiagnosisService } from './listOfAllDiagnosis.service';

@Component({
    selector: 'cc-listOfDiagnosis',
    templateUrl: './listOfDiagnosis.component.html'
})

export class ListOfDiagnosis implements OnInit{

    public listDiag : listOfDiagnosis[];
    constructor(private _listOfDiagnosisService: listOfDiagnosisService) {}

    ngOnInit(){
        this._listOfDiagnosisService.getListOfDiagnosis().subscribe(
            data=>{
                this.listDiag = data;
            },
            error=>console.error('Error!',error)
        )
    }
}