import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Room } from './room';
import { RoomTerms } from './roomTerms';

@Injectable({
    providedIn: 'root'
})
export class DeleteRoomService{
    getRoomTerms2(datee: any, selRoom: any, id: string) {
        throw new Error("Method not implemented.");
    }
    _url = 'http://localhost:8080/api/rooms/del';
    _url2 = 'http://localhost:8080/api/rooms/getAll';
    _url3 = 'http://localhost:8080/api/rooms/edit';
    _url4 = 'http://localhost:8080/api/roomTerms/getAllDate';
    _url5 = 'http://localhost:8080/api/roomTerms/getAllDate';
    _url6 = 'http://localhost:8080/api/rooms/getEx';


    
    constructor(private _http: HttpClient) { }

    deleteRoom(id: number): Observable<void> {
       return  this._http.delete<void>(`${this._url}/${id}`);
    }

    getRooms():Observable<any> {
        return this._http.get<Room[]>(this._url2);
    }

    getRoomsEx():Observable<any> {
        return this._http.get<Room[]>(this._url6);
    }

    editRooms(room: Room) : Observable<Room> {
        return  this._http.put<Room>(this._url3, room);
     }

     getRoomTerms(date: string) : Observable<any> {
         return this._http.get<RoomTerms>(`${this._url4}/${date}`);
     }

     getRoomTerms22(date: string, room : string) : Observable<any> {
        return this._http.get<RoomTerms>(`${this._url5}/${date}/${room}`);
    }
}