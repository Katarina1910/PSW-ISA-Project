import { Component, OnInit, Input } from '@angular/core';
import { Router } from '@angular/router';
import { Room } from './room';
import { DeleteRoomService } from './deleteRoom.servce';
import { RoomTerms } from './roomTerms';



@Component({
    selector: 'ca-delRoom',
    templateUrl: './deleteRoom.component.html'
})

export class DeleteRoomComponent implements OnInit {
    public rooms: Room[];
    editModel = new Room(null,null,null);
    edit : boolean = false;
    public editedRoom:Room;

    public filteredRooms : Room[];
    public pListRooms: Room[] = [];
    public _roomName: string;
    public _roomId: string;
    public _roomDate: string;
    public roomTerms: RoomTerms[];
    datee : any = new Date().toISOString();
    tabela1: boolean = true;
    tabela2: boolean = false;
    
    constructor(private _deleteRoomService: DeleteRoomService,private router: Router) {}

    get roomName():string{
        return this._roomName;
    }

    set  roomName(value:string){
        this._roomName=value;
        this.filteredRooms = this.roomName ? this.filter(this.roomName):this.rooms;
    }
    filter(filterField:string):Room[]{
        filterField = filterField.toLocaleLowerCase();
        return this.rooms.filter((pat:Room)=>pat.name.toLowerCase().indexOf(filterField)!=-1);
    }

    get roomId():string{
        return this._roomId;
    }

    set roomId(value:string){
        this._roomId=value;
        this.filteredRooms = this.roomId ? this.filter3(this.roomId):this.rooms;
    }
    
    filter3(filterField:string):Room[]{
        filterField = filterField.toLocaleLowerCase();
        return this.rooms.filter((pat:Room)=>pat.id.toString().toLowerCase().indexOf(filterField)!=-1);
    }


    ngOnInit() { 
        this._deleteRoomService.getRooms().subscribe(
        data=>{
          
            this.rooms = data;
            this.filteredRooms = data;
            for(var d of this.rooms){
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

    onSubmitDate(){
        const mySQLDateString = this.datee.slice(0, 10).replace('T', ' ');
        this.datee = mySQLDateString
        console.log(this.datee)
        this.tabela1 = false;
        this.tabela2=true;
        this._deleteRoomService.getRoomTerms(this.datee).subscribe(
            data=>{
                this.roomTerms = data;
               // console.log(this._roomDate);
                console.log(this.roomTerms);
                this.router.navigate(['/HomepageCA/allRooms']);
            },
            error=> console.error('Error!', error)
        )
        this.edit = false; 
    }
 

}