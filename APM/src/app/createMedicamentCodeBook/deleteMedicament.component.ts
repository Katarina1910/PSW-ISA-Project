import { Component, OnInit } from "@angular/core";
import { Medicament } from './medicament';
import { DeleteMedicamentService } from './deleteMedicament.service';
import { Router } from '@angular/router';


@Component({
    selector: 'cca-delMed',
    templateUrl: './deleteMedicament.component.html'
})

export class DeleteMedicamentComponent implements OnInit{

    public medicaments: Medicament[];
    public editModel = new Medicament(null,null,null, null);
    edit : boolean = false;
    public editedMed:Medicament;

    constructor(private _deleteMedicamentService: DeleteMedicamentService, private router: Router) {}

    ngOnInit(){
        this._deleteMedicamentService.getMedicaments().subscribe(
            data=>{
              this.medicaments = data;
              for(var m of this.medicaments){
                  console.log(JSON.stringify(m));
              }  
            },
            error => console.error('Error!',error)
        )}

        deleteMedicaments(id:number): void{
           this._deleteMedicamentService.deleteMedicaments(id).subscribe(
                data=>{
                    alert('Medicament deleted!');
                    this.router.navigate(['/HomepageCCA']);
                },
                error => console.error('Error!',error)
            )
        }

        editMedicament(m:Medicament):void{   
            this.edit = true;
            this.editModel.name = m.name;
            this.editModel.description = m.description;
            this.editModel.id = m.id;
            this.editModel.code = m.code;
        }

        onSubmit(){
            this._deleteMedicamentService.editMedicament(this.editModel).subscribe(
                data=>{
                    alert('Medicament edited!');
                    this.editedMed = data as Medicament;
                    
                    this.router.navigate(['/HomepageCCA']);
                },
                error=> console.error('Error!', error)
            )
            this.edit = false; 
        }

    }