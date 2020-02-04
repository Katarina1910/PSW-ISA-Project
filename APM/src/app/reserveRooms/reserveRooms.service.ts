
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Room } from '../rooms/room';

@Injectable({
    providedIn: 'root'
})
export class ReserveRoomService{
    _url = 'http://localhost:8080/api/ConsultTerm/res';

    id: string;
    idr:number;

    constructor(private _http: HttpClient) { }

    reserveRoom(room: Room, s: string) {
        this.idr  = room.id;
       return  this._http.post<any>(`${this._url}/${this.idr}/${s}/${this.id}`, room);
    }

}