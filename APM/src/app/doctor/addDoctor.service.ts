import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { User } from '../registration/user';
import { Doctor } from './doctor';

@Injectable({
    providedIn: 'root'
})
export class AddDoctorService{
    _url = 'http://localhost:8080/api/doctors';
    _url2 = 'http://localhost:8080/api/doctors/rateDoctor';
    id: string;


    constructor(private _http: HttpClient) { }

    addDoctor(doctor: User) {
       return  this._http.post<any>(`${this._url}/${this.id}`, doctor);
    }

    rateDoctor(doc: Doctor, rate: any) {
        return this._http.put<void>(`${this._url2}/${rate}`, doc);
    }
}