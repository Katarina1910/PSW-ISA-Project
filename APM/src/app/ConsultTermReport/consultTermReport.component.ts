import { OnInit, Component } from '@angular/core';
import { IDropdownSettings } from 'ng-multiselect-dropdown';

import { listOfDiagnosis } from '../listOfAllDiagnosis/listOfAllDiagnosis';
import { listOfDiagnosisService } from '../listOfAllDiagnosis/listOfAllDiagnosis.service';
import { listOfMedicamentService } from '../listOfMedicaments/listOfMedicament.service';
import { listOfMedicaments } from '../listOfMedicaments/listOfMedicament';
import { ConsultTermReportService } from './consultTermReport.service';
import { ConsultTerm } from '../consultTerm/consultTerm';
import { Medicament } from '../createMedicamentCodeBook/medicament';
import { Diagnosis } from '../createDiagCodeBook/diagnosis';
import { ListOfMedicament } from '../listOfMedicaments/listOfMedicament.component';
import { ListOfDiagnosis } from '../listOfAllDiagnosis/listOfAllDiagnosis.component';
import { Recipe } from './Recipe';
import { Router } from '@angular/router';


@Component({
    selector: 'consu-term-report',
    templateUrl: './consultTermReport.component.html'
  })

  export class ConsultTermReportComponent implements OnInit {

    dropdownList = [];
    selectedItems = [];
    dropdownSettings = {};



    public consult = new ConsultTerm(null,null,null,null,null,null,null,null, null,null); 
    public listDiag : [];
    public listMed : [];
    public report : string;
    public recipe: Recipe;
    public selectedMedicaments : Array<any>;
    public medicamentsSettings : {};
    public selectedDiagnosis : {}; 
    public diagnosisSettings : {};

    constructor(private _listOfDiagnosisService: listOfDiagnosisService,private _listOfMedicametService: listOfMedicamentService,
      private router: Router,
      private _consultTermReportService: ConsultTermReportService) {}

    ngOnInit(){
        this._listOfDiagnosisService.getListOfDiagnosis().subscribe(
          data=>{
              this.listDiag = data;
          },
          error=>console.error('Error!',error)
         )

         this._listOfMedicametService.getListOfMedicament().subscribe(
          data=>{
              this.listMed = data;
          },
          error=>console.error('Error!',error)
        )

        this.medicamentsSettings = {
            singleSelection: false,
            idField: 'id',
            textField: 'name',

            selectAllText: 'Select All',
            unSelectAllText: 'UnSelect All',
            itemsShowLimit: 3,
            allowSearchFilter: true
          };
    }

    onItemSelect(item: any) {
        console.log(item);
      }
      onSelectAll(items: any) {
        console.log(items);

      }
}
