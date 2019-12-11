import { Component } from '@angular/core';
import { Medicament } from './medicament';
import { Router } from '@angular/router';
import { createMedicamentCodeBookService } from './createMedicamentCodeBook.service';

@Component({
    selector: 'cca-crtmedcdb',
    templateUrl: './createMedicamentCodeBook.component.html'
})

export class createMedicamentCodeBook{

        medicamentModel = new Medicament('','','', 0.0);
    
        constructor(private _createMedicamentCodeBookService: createMedicamentCodeBookService, private router: Router){}
    
        onSubmit(){
    
            this._createMedicamentCodeBookService.CreateMedicamentCodeBook(this.medicamentModel)
            .subscribe(
                data => {
                    console.log('Success!', JSON.stringify(data))
                    alert('Medicament added!');
                    this.router.navigate(['/HomepageCCA']);
                },
                error => console.error('Error!', error)
            )
        }
}