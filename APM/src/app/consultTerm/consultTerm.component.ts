import { Component, OnInit } from '@angular/core';
import { ConsultTerm } from './consultTerm';
import { ConsultTermService } from './consultTerm.service';
import { Router } from '@angular/router';
import { Room } from '../rooms/room';
import { DeleteRoomService } from '../rooms/deleteRoom.servce';
import { User } from '../registration/user';
import { DeleteDoctorService } from '../doctor/deleteDoctor.service';

@Component({
    selector : 'cc-consultTerm',
    templateUrl : './consultTerm.component.html'
})
export class ConsultTermComponent implements OnInit {
    public rooms: Room[];
    public doctors: User[];

    ngOnInit(): void {
        this._deleteRoomService.getRooms().subscribe(
            data=>{ 
                this.rooms = data;
            },
            error=> console.error('Error!', error)
        )

        this._delDOoctorService.getDoctors().subscribe(
            data=> this.doctors = data,
            error=> console.error('Error!', error)
            
        )
    }
    consultTermModel = new ConsultTerm(null,null,null,null,null,null,null,null,null);
    
    constructor(private _consultTermService: ConsultTermService, private router:Router,
        private _deleteRoomService: DeleteRoomService, private _delDOoctorService: DeleteDoctorService) {}

    onSubmit(){
        this._consultTermService.addConsultTerm(this.consultTermModel)
       .subscribe(
           data=> {
               alert('Success!');
               console.log('Success!', JSON.stringify(data));
               this.router.navigate(['/welcome']);
           },
            error=> console.error('Error!',error)
        )
    }
}