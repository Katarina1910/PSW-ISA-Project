import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { arrivedRequest } from './arrivedRequest.component';
import { Observable } from 'rxjs';
import { RequestForPatReg } from '../registration/requestForPatReg';

@Injectable({
    providedIn: 'root'
})
export class arrivedRequestService{

    _url = 'http://localhost:8080/api/RqForPatientReg/getAll';
    _url2 = 'http://localhost:8080/api/mail/accept';
    _url3 = 'http://localhost:8080/api/mail/reject';
    _url4 = 'http://localhost:8080/api/patient/add';

    constructor(private _http: HttpClient) { }

    getArrivedRequests():Observable<any>{
        return this._http.get<arrivedRequest[]>(this._url);
    }

    sendActivationEmail(id: any,email:any, arrReq: arrivedRequest[] ) {
        return this._http.put<void>(`${this._url2}/${email}/${id}`, arrReq);
    }

    sendRejectEmail(email:any,reason:string) {
        return this._http.get<void>(`${this._url3}/${email}/${reason}`);
    }

    addPatient(id: any, arrReq: arrivedRequest[]) {
        return  this._http.post<arrivedRequest[]>(`${this._url4}/${id}`, arrReq);
     }

}