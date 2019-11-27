import { Component, OnInit, Input } from '@angular/core';
import { User } from '../registration/user';
import { DeleteDoctorService } from './deleteDoctor.service';
import { Login } from '../login/login';
import { Router } from '@angular/router';



@Component({
    selector: 'ca-delDoctor',
    templateUrl: './deleteDoctor.component.html'
})

export class DeleteDoctorComponent implements OnInit {
    public doctors: User[];
    
    constructor(private _deleteDoctorService: DeleteDoctorService,private router: Router) {}

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

    deleteDoctor(email:string): void{
        this._deleteDoctorService.deleteDoctor(email).subscribe(
            data=>{
                alert('Doctor deleted!');
                this.router.navigate(['/welcome']);
            },
            error=> console.error('Error!', error)
        )
       
    }
 

}