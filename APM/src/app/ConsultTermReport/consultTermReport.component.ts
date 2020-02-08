import { OnInit, Component } from '@angular/core';

import { listOfDiagnosis } from '../listOfAllDiagnosis/listOfAllDiagnosis';
import { listOfDiagnosisService } from '../listOfAllDiagnosis/listOfAllDiagnosis.service';
import { listOfMedicamentService } from '../listOfMedicaments/listOfMedicament.service';
import { listOfMedicaments } from '../listOfMedicaments/listOfMedicament';
import { ConsultTermReportService } from './consultTermReport.service';
import { ConsultTerm } from '../consultTerm/consultTerm';
import { Recipe } from './Recipe';
import { Router } from '@angular/router';
import { DoctorWorkCalService } from '../doctorWorkingCalendar/doctorWorkCal.service';
import { Consult } from './Consult';

@Component({
    selector: 'consu-term-report',
    templateUrl: './consultTermReport.component.html'
  })

  export class ConsultTermReportComponent implements OnInit {

    public consultTerm = new ConsultTerm(null,null,null,null,null,null,null,null, null,null,null); 
    public listDiag : [];
    public listMed : [];
    public report : string;
    public recipe: Recipe;
    public consult =  new Consult(null,null,null,null,null,null);
    public selectedMedicaments : Array<any>;
    public medicamentsSettings : {};
    public selectedDiagnosis : {}; 
    public diagnosisSettings : {};

    constructor(private _listOfDiagnosisService: listOfDiagnosisService,private _listOfMedicametService: listOfMedicamentService,
      private router: Router,
      private _consultTermReportService: ConsultTermReportService,
      private _workCalendarService: DoctorWorkCalService) {}

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
          
          this.diagnosisSettings = {
            singleSelection: true,
            idField: 'id',
            textField: 'name',
            allowSearchFilter: true
          };

          this._workCalendarService.getConsult(this._consultTermReportService.id).subscribe(
            data=>{
                  this.consultTerm = data;
            },error=>{

            }
          );
    }

    private onAddReport(): void{
          if(this.selectedMedicaments == null || this.selectedDiagnosis == null || this.report === null || this.report === undefined || this.report ===""){
            alert("Please fill information");
            return;
          }
          this.consult.report = this.report;
          this.consult.consultTerm = this.consultTerm;
          this.consult.diagnosis = new listOfDiagnosis(this.selectedDiagnosis[0].id,null,null,null);
          this.recipe = new Recipe(null,null,null, null, null,null);
          this.recipe.medicaments = <listOfMedicaments[]>[];
          for(let i=0; i<this.selectedMedicaments.length; i++){
              this.recipe.medicaments.push(new  listOfMedicaments(this.selectedMedicaments[i].id,null,null,null));
          }
          this.consult.recipe = this.recipe;

          this._consultTermReportService.addConsultTerm(this.consult).subscribe(
            data =>{
              this.router.navigate(['HompageDoctor/DoctorWorkCalendar']);
            },error => {
              alert("Consult report hasn't been sabed properly");
            }
          );

    }


}
