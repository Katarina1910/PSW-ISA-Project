import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { RequestForPatReg } from './requestForPatReg';

@Injectable({
    providedIn: 'root'
})
export class UserService{
    _url = 'http://localhost:8080/api/users/public/add-user';
    _url2 = 'http://localhost:8080/api/RqForPatientReg';

    constructor(private _http: HttpClient) { }

    enroll(requestForPatReg: RequestForPatReg) {
       return  this._http.post<any>(this._url, requestForPatReg);
    }

    addPatientRequest(patient: User) {
        return  this._http.post<any>(this._url2, patient);
    }
}