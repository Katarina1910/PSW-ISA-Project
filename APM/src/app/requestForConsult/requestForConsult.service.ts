import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { RequestForConsult } from './requestForConsult';

@Injectable({
    providedIn: 'root'
})
export class RequestForConsultService{
    _url = 'http://localhost:8080/api/rqForConsult';

    constructor(private _http: HttpClient) { }

    addRequestForConsult(requestForConsult: RequestForConsult) {
       return  this._http.post<any>(this._url, requestForConsult);
    }
}