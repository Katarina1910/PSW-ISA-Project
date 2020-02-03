import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { RequestForAbsence } from './requestForAbsence';

@Injectable({
    providedIn: 'root'
})
export class RequestForAbsenceService{
    _url = 'http://localhost:8080/api/RqForAbsence';

    constructor(private _http: HttpClient) { }

    addRequestForAbsence(request: RequestForAbsence) {
       return  this._http.post<any>(this._url, request);
    }
}