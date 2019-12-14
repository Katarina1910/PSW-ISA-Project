import { Component, OnInit } from "@angular/core";
import { Router } from '@angular/router';
import { Diagnosis } from './diagnosis';
import { DeleteDiagnosisService } from './deleteDiagnosis.service';


@Component({
    selector: 'cca-delDiag',
    templateUrl: './deleteDiagnosis.component.html'
})

export class DeleteDiagnosisComponent implements OnInit{

    public diagnosis: Diagnosis[];
    public editModel = new Diagnosis(null,null,null, null);
    edit : boolean = false;
    public editedDiag:Diagnosis;

    constructor(private _deleteDiagnosisService: DeleteDiagnosisService, private router: Router) {}

    ngOnInit(){
        this._deleteDiagnosisService.getDiagnosis().subscribe(
            data=>{
              this.diagnosis = data;
              for(var d of this.diagnosis){
                  console.log(JSON.stringify(d));
              }  
            },
            error => console.error('Error!',error)
        )}

        deleteDiagnosis(id:number): void{
           this._deleteDiagnosisService.deleteDiagnosis(id).subscribe(
                data=>{
                    alert('Diagnosis deleted!');
                    this.router.navigate(['/HomepageCCA/allDiagnosis']);
                },
                error => console.error('Error!',error)
            )
        }

        editDiagnosis(d:Diagnosis):void{   
            this.edit = true;
            this.editModel.name = d.name;
            this.editModel.description = d.description;
            this.editModel.id = d.id;
            this.editModel.code = d.code;
        }

        onSubmit(){
            this._deleteDiagnosisService.editDiagnosis(this.editModel).subscribe(
                data=>{
                    alert('Diagnosis edited!');
                    this.editedDiag = data as Diagnosis;
                    
                    this.router.navigate(['/HomepageCCA']);
                },
                error=> console.error('Error!', error)
            )
            this.edit = false; 
        }

    }