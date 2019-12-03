import { Component, OnInit } from '@angular/core';
import { ConsultTerm } from './consultTerm';
import { ConsultTermService } from './consultTerm.service';
import { Router } from '@angular/router';
import { Room } from '../rooms/room';
import { DeleteRoomService } from '../rooms/deleteRoom.servce';

@Component({
    selector : 'cc-consultTerm',
    templateUrl : './consultTerm.component.html'
})
export class ConsultTermComponent implements OnInit {
    public rooms: Room[];
    ngOnInit(): void {
        this._deleteRoomService.getRooms().subscribe(
            data=>{ 
                this.rooms = data;
            },
            error=> console.error('Error!', error)
        )
    }
    consultTermModel = new ConsultTerm('','','','','');
    
    constructor(private _consultTermService: ConsultTermService, private router:Router,private _deleteRoomService: DeleteRoomService) {}

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