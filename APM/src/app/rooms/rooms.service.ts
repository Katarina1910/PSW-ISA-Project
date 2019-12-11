import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Room } from './room';

@Injectable({
    providedIn: 'root'
})
export class AddRoomService{
    _url = 'http://localhost:8080/api/rooms';

    constructor(private _http: HttpClient) { }

    addRoom(room: Room) {
       return  this._http.post<any>(this._url, room);
    }
}