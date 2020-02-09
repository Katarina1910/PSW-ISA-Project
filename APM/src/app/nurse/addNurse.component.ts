import { Component } from '@angular/core';
import { User } from '../registration/user';
import { Router } from '@angular/router';
import { AddNurseService } from './addNurse.service';


@Component({
    selector: 'ca-addnewNurse',
    templateUrl: './addNurse.component.html'
})

export class AddNurseComponent{
    
    nurseModel = new User('','','','','','','','','','','','',"",false);
    password1 : string = "";
    
    constructor(private _addNurseService: AddNurseService,  private router: Router) {}

    onSubmit(){
        if(this.nurseModel.password != this.password1){
            alert("Password don't match!");
            return;
        }
        
        this._addNurseService.addNurse(this.nurseModel)
       .subscribe(
           data=>{
            console.log('Success!', JSON.stringify(data))
            alert('Nurse added!');
            this.router.navigate(['/HomepageCA']);
           } ,
            error=> console.error('Error!',error)
        )
    }

}