import { Component } from '@angular/core';
import { Diagnosis } from './diagnosis';
import { createDiagnosisCodeBookService } from './createDiagnosisCodeBook.service';
import { Router } from '@angular/router';


@Component({
    selector: 'cca-crtdiagcdb',
    templateUrl: './createDiagCodeBook.component.html'
})

export class createDiagnosisCodeBook{

    diagModel = new Diagnosis('','','',0.0);

    constructor(private _createDiagnosisCodeBookService: createDiagnosisCodeBookService, private router: Router){}
 
    onSubmit(){
    
        this._createDiagnosisCodeBookService.CreateDiagnosisCodeBook(this.diagModel)
        .subscribe(
            data => {
                console.log('Success!', JSON.stringify(data))
                alert('Diagnosis added!');
                this.router.navigate(['/HomepageCCA']);
            },
            error => console.error('Error!', error)
        )
    }
}