import { Component, OnInit } from '@angular/core';
import { User } from '../registration/user';
import { AddDoctorService } from './addDoctor.service';
import { Router } from '@angular/router';
import { Doctor } from './doctor';
import { UserService } from '../registration/user.service';


@Component({
    selector: 'ca-addnewDoctor',
    templateUrl: './addDoctor.component.html'
})

export class AddDoctorComponent implements OnInit{
    ngOnInit(): void {
        this._userService.getUserInfo().subscribe(
            data=>{
                this.user = data;
                console.log(data);
                this._addDoctorService.id = this.user.id;
            }
        )
    }
    doctorModel = new Doctor(null,null,null);
    user = new User(null,null,null,null,null,null,null,null,null,null,null,null)
    
    constructor(private _addDoctorService: AddDoctorService,  private router: Router, private _userService : UserService) {}

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