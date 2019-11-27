import { Component, OnInit } from '@angular/core';
import { User } from '../registration/user';
import { DeleteDoctorService } from './deleteDoctor.service';



@Component({
    selector: 'ca-delDoctor',
    templateUrl: './deleteDoctor.component.html'
})

export class DeleteDoctorComponent implements OnInit {
    //doctorModel = new User('','','','','','','','','','','','');
    public doctors: User[];
    constructor(private _deleteDoctorService: DeleteDoctorService) {}

    ngOnInit() { 
        this._deleteDoctorService.getDoctors().subscribe(
        data=>{
          
            this.doctors = data;
            for(var d of this.doctors){
                console.log(JSON.stringify(d));
            }

        },
        error=> console.error('Error!', error)
    ) }



  /*   deleteDoctor(){
        this._deleteDoctorService.deleteDoctor(this.doctorModel)
       .subscribe(
           data=>{
            console.log('Success!', JSON.stringify(data))
            alert('Doctor added!')
           } ,
            error=> console.error('Error!',error)
        )
    } */

}