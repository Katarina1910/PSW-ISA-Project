import { Component, OnInit, Input } from '@angular/core';
import { Router } from '@angular/router';
import { Room } from './room';
import { DeleteRoomService } from './deleteRoom.servce';



@Component({
    selector: 'ca-delRoom',
    templateUrl: './deleteRoom.component.html'
})

export class DeleteRoomComponent implements OnInit {
    public rooms: Room[];
    
    constructor(private _deleteRoomService: DeleteRoomService,private router: Router) {}


    ngOnInit() { 
        this._deleteRoomService.getRooms().subscribe(
        data=>{
          
            this.rooms = data;
            for(var d of this.rooms){
                if(d.getIsFree){
                    d.setFree("Da");
                }else{
                    d.setFree("Ne");
                }
                console.log(JSON.stringify(d));
            }

        },
        error=> console.error('Error!', error)
    ) }

    deleteRoom(id:number): void{
        this._deleteRoomService.deleteRoom(id).subscribe(
            data=>{
                alert('Room deleted!');
                this.router.navigate(['/HomepageCA']);
            },
            error=> console.error('Error!', error)
        )
       
    }
 

}