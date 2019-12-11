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
    editModel = new Room(null,null,null,null);
    edit : boolean = false;
    public editedRoom:Room;
    
    constructor(private _deleteRoomService: DeleteRoomService,private router: Router) {}


    ngOnInit() { 
        this._deleteRoomService.getRooms().subscribe(
        data=>{
          
            this.rooms = data;
            for(var d of this.rooms){
               /* if(d.isFree){
                    d.free = "Da";
                }else{
                    d.free="Ne";
                }*/
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

    editRoom(d:Room):void{   
        this.edit = true;
       this.editModel.name = d.name;
       this.editModel.type = d.type;
       this.editModel.id = d.id;
    }

    onSubmit(){
        this._deleteRoomService.editRooms(this.editModel).subscribe(
            data=>{
                alert('Room edited!');
                this.editedRoom = data as Room;
                
                this.router.navigate(['/HomepageCA/allRooms']);
            },
            error=> console.error('Error!', error)
        )
        this.edit = false; 
    }
 

}