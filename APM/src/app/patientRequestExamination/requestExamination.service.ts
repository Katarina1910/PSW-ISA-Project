import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { ConsultTerm } from '../consultTerm/consultTerm';

@Injectable({
    providedIn: 'root'
})
export class requestExamination{

    _url = 'http://localhost:8080/api/appointedExaminations/add';

    constructor(private _http: HttpClient) { }

    appointExamination(consultTerm: ConsultTerm) {
        return  this._http.post<any>(this._url, consultTerm);  
    }
    
}