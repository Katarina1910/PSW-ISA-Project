import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { DoctorRequestForConsult } from './doctorRequestForConsult';

@Injectable({
    providedIn: 'root'
})
export class DoctorRequestForConsultService{
    _url = 'http://localhost:8080/api/rqForConsult/doctor';

    constructor(private _http: HttpClient) { }

    addRequestForConsult(requestForConsult: DoctorRequestForConsult) {
       return  this._http.post<any>(this._url, requestForConsult);
    }
}