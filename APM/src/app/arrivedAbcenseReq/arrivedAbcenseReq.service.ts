import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { RequestForAbsence } from '../requestForAbsence/requestForAbsence';


@Injectable({
    providedIn: 'root'
})
export class arrivedAbcenseReqService{

    _url = 'http://localhost:8080/api/RqForAbsence/getAll';
    _url2 = 'http://localhost:8080/api/mail/accept';
    _url3 = 'http://localhost:8080/api/mail/reject';
    _url4 = 'http://localhost:8080/api/patient/add';
    //_url5 = 'http://localhost:8080/api/RqForPatientReg/reject'

    constructor(private _http: HttpClient) { }

    getArrivedRequests():Observable<any>{
        return this._http.get<RequestForAbsence[]>(this._url);
    }

    sendActivationEmail(id: any,email:any, arrReq: RequestForAbsence[] ) {
        return this._http.put<void>(`${this._url2}/${email}/${id}`, arrReq);
    }

    sendRejectEmail(email:any,reason:string,id:any) {
        return this._http.get<void>(`${this._url3}/${email}/${reason}/${id}`);
    }

    addPatient(id: any, arrReq: RequestForAbsence[]) {
        return  this._http.post<RequestForAbsence[]>(`${this._url4}/${id}`, arrReq);
     }

     removeArrivedRequest(id: any) {
       // return  this._http.delete<RequestForAbsence[]>(`${this._url5}/${id}`);
     }

}