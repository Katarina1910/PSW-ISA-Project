import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { ConsultTerm } from './consultTerm';

@Injectable({
    providedIn: 'root'
})
export class ConsultTermService{
    _url = 'http://localhost:8080/api/..';

    constructor(private _http: HttpClient) { }

    addConsultTerm(consultTerm: ConsultTerm) {
       return  this._http.post<any>(this._url, consultTerm);
    }
}