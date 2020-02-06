
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Room } from '../rooms/room';
import { DoctorTerm } from './doctorTerm';
import { Observable } from 'rxjs';
import { Doctor } from '../doctor/doctor';

@Injectable({
    providedIn: 'root'
})
export class ReserveRoomService{
    _url = 'http://localhost:8080/api/ConsultTerm/res';
    _url2 = 'http://localhost:8080/api/doctors/getAll';
    _url5 = 'http://localhost:8080/api/doctorTerms/getAllDate';

    id: string;
    idr:number;
    doctorId: string;

    constructor(private _http: HttpClient) { }

    reserveRoom(date: string, term: string, room: string, doctor : string) {
        console.log('soba'+date +' '+ term + '  '+doctor+' ')
       return  this._http.post<any>(`${this._url}/${date}/${term}/${room}/${this.doctorId}/${this.id}`, null );
    }

    getDoctorTerms(date: string, term: string) : Observable<any> {
        return this._http.get<DoctorTerm>(`${this._url5}/${date}/${term}`);
    }

    

}