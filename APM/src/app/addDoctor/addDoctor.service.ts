import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { User } from '../registration/user';

@Injectable({
    providedIn: 'root'
})
export class AddDoctorService{
    _url = 'http://localhost:8080/api/..';

    constructor(private _http: HttpClient) { }

    addDoctor(doctor: User) {
       return  this._http.post<any>(this._url, doctor);
    }
}