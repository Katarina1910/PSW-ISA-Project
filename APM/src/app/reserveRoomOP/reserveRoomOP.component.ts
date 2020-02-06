import { Component, OnInit, Input } from '@angular/core';
import { Router } from '@angular/router';
import { Room } from '../rooms/room';
import { RoomTerms } from '../rooms/roomTerms';
import { DeleteRoomService } from '../rooms/deleteRoom.servce';
import { DoctorRequestForOperationService } from '../doctorRqForOperation/doctorRqForOperaton.service';
import { DoctorTerm } from '../reserveRooms/doctorTerm';
import { ReserveRoomOPService } from './reserveRoomOP.service';
import { DoctorRequestForOperation } from '../doctorRqForOperation/doctorRqForOperaton';




@Component({
    templateUrl: './reserveRoomOP.component.html'
})

export class ReserveRoomsOPComponent implements OnInit {
    public rooms: Room[];
    public rqs: DoctorRequestForOperation[];
    public roomTerms: RoomTerms[];
    datee : any = new Date().toISOString();
    selRoom : any = new Date().toISOString();
    selRoomReserve : string;
    public docTerms : DoctorTerm[];
    public selDoctor : string;

    
    constructor(private _deleteRoomService: DeleteRoomService,private router: Router,
         private _rqsService : DoctorRequestForOperationService, private _rrService : ReserveRoomOPService) {}


    ngOnInit() { 
        this._rqsService.getRequests().subscribe(
            data=>{
                this.rqs = data;
                console.log(data)
            }
        )
        this._deleteRoomService.getRoomsOp().subscribe(
        data=>{
            this.rooms = data;
        },
        error=> console.error('Error!', error)
    ) }


    onSubmitDate(idd:string){
        this._rrService.id = idd;
        console.log(idd);
        const mySQLDateString = this.datee.slice(0, 10).replace('T', ' ');
        this.datee = mySQLDateString
        console.log(this.selRoom)
        this._deleteRoomService.getRoomTerms22(this.datee, this.selRoom).subscribe(
            data=>{
                this.roomTerms = data;
                console.log(this.roomTerms);
               // this.router.navigate(['/HomepageCA/allRooms']);
            },
            error=> console.error('Error!', error)
        )
    }

    onSelectTerm(){
        this._rrService.getDoctorTerms(this.datee, this.selRoomReserve).subscribe(
            data=>{
                this.docTerms = data;
                console.log(this.docTerms)
            }
        )
    }

    onSubmitRoom(){
        this._rrService.doctorId = this.selDoctor;
        alert(this.selDoctor)
        console.log(this.selRoomReserve)
        this._rrService.reserveRoomOP(this.datee,this.selRoomReserve,this.selRoom, this.selDoctor).subscribe(
            data=>{
                console.log(data)
            }
        )
    }
 

}