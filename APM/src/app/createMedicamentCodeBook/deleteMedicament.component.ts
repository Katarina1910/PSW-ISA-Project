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
    }