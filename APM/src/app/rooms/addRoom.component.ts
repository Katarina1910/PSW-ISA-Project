import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { Room } from './room';
import { AddRoomService } from './rooms.service';


@Component({
    selector: 'ca-addnewRoom',
    templateUrl: './addRoom.component.html'
})

export class AddRoomComponent{
    roomModel = new Room(null,null,null,null);
    
    constructor(private _addRoomService: AddRoomService,  private router: Router) {}

    onSubmit(){
        console.log(JSON.stringify(this.roomModel));
        this._addRoomService.addRoom(this.roomModel)
       .subscribe(
           data=>{
            console.log('Success!', JSON.stringify(data))
            alert('Room added!');
            this.router.navigate(['/HomepageCA']);
           } ,
            error=> console.error('Error!',error)
        )
    }

}