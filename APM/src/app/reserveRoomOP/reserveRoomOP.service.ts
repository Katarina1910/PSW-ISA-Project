
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Room } from '../rooms/room';
import { Observable } from 'rxjs';
import { DoctorTerm } from '../reserveRooms/doctorTerm';

@Injectable({
    providedIn: 'root'
})
export class ReserveRoomOPService{
    _url = 'http://localhost:8080/api/rqForOperation/res';
    _url2 = 'http://localhost:8080/api/doctors/getAll';
    _url5 = 'http://localhost:8080/api/doctorTerms/getAllDate';

    id: string;
    idr:number;
    doctorId: string;

    constructor(private _http: HttpClient) { }

    reserveRoomOP(date: string, term: string, room: string, doctor : string) {
        console.log('soba'+date +' '+ term + '  '+doctor+' ')
       return  this._http.post<any>(`${this._url}/${date}/${term}/${room}/${this.doctorId}/${this.id}`, null );
    }

    getDoctorTerms(date: string, term: string) : Observable<any> {
        return this._http.get<DoctorTerm>(`${this._url5}/${date}/${term}`);
    }

    

}