import { Component, OnInit, Input } from '@angular/core';
import { User } from '../registration/user';
import { Login } from '../login/login';
import { Router } from '@angular/router';
import { DeleteNurseService } from './deleteNurse.service';

@Component({
    selector: 'ca-delNurse',
    templateUrl: './deleteNurse.component.html'
})

export class DeleteNurseComponent implements OnInit {

    public nurses: User[];    
    constructor(private _deleteNurseService: DeleteNurseService,private router: Router) {}

    ngOnInit() { 
        this._deleteNurseService.getNurses().subscribe(
        data=>{
          
            this.nurses = data;
            for(var n of this.nurses){
                console.log(JSON.stringify(n));
            }

        },
        error=> console.error('Error!', error)
    ) }

    deleteNurse(email:string): void{
        this._deleteNurseService.deleteNurse(email).subscribe(
            data=>{
                alert('Nurse deleted!');
                this.router.navigate(['/welcome']);
            },
            error=> console.error('Error!', error)
        )
       
    }
 

}