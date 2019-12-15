import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { ConsultTerm } from './consultTerm';
import { Observable } from 'rxjs';

@Injectable({
    providedIn: 'root'
})
export class ConsultTermService{
    _url = 'http://localhost:8080/api/ConsultTerm';
    _url2 = 'http://localhost:8080/api/patient/getAllExaminations';

    constructor(private _http: HttpClient) { }

    addConsultTerm(consultTerm: ConsultTerm) {
       return  this._http.post<any>(this._url, consultTerm);  
    }

    public getConsultTermsInfo(): Observable<any> {
        return this._http.get(this._url2);
    }
}