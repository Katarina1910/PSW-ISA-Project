import { Component, OnInit, Input } from '@angular/core';
import { User } from '../registration/user';
import { Router } from '@angular/router';
import { DeleteClinicsService } from './deleteClinics.service';
import { Clinic } from './clinic';



@Component({
    selector: 'cca-delClinic',
    templateUrl: './deleteClinics.component.html'
})

export class DeleteClinicsComponent implements OnInit {
    public clinics: Clinic[];
    
    constructor(private _deleteClinicsService: DeleteClinicsService, private router: Router) {}

    ngOnInit() { 
        this._deleteClinicsService.getClinics().subscribe(
        data=>{
          
            this.clinics = data;
            for(var c of this.clinics){
                console.log(JSON.stringify(c));
            }

        },
        error=> console.error('Error!', error)
    ) }

    deleteClinics(id:number): void{
        this._deleteClinicsService.deleteClinics(id).subscribe(
            data=>{
                alert('Clinic deleted!');
                this.router.navigate(['/HomepageCCA']);
            },
            error=> console.error('Error!', error)
        )  
    }

    onClick(){
        console.log("Clinics deleted");
    }
}