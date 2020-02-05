import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { DoctorRequestForConsult } from './doctorRequestForConsult';
import { Observable } from 'rxjs';

@Injectable({
    providedIn: 'root'
})
export class DoctorRequestForConsultService{
    _url = 'http://localhost:8080/api/rqForConsult/doctor';
    _url1 = 'http://localhost:8080/api/rqForConsult/getAll';

    constructor(private _http: HttpClient) { }

    addRequestForConsult(requestForConsult: DoctorRequestForConsult) {
       return  this._http.post<any>(this._url, requestForConsult);
    }

    getRequests() : Observable<any>{
        return  this._http.get(this._url1);
     }
}