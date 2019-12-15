import { Component } from '@angular/core';
import { User } from '../registration/user';
import { AddDoctorService } from './addDoctor.service';
import { Router } from '@angular/router';


@Component({
    selector: 'ca-addnewDoctor',
    templateUrl: './addDoctor.component.html'
})

export class AddDoctorComponent{
    doctorModel = new User('','','','','','','','','','','','');
    
    constructor(private _addDoctorService: AddDoctorService,  private router: Router) {}

    onSubmit(){
        this._addDoctorService.addDoctor(this.doctorModel)
       .subscribe(
           data=>{
            console.log('Success!', JSON.stringify(data))
            alert('Doctor added!');
            this.router.navigate(['/welcome']);
           } ,
            error=> console.error('Error!',error)
        )
    }

}