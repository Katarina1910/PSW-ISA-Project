import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { ConsultTerm } from '../consultTerm/consultTerm';
import { User } from '../registration/user';

@Injectable({
    providedIn: 'root'
})
export class requestExamination{

    _url = 'http://localhost:8080/api/rqForConsult/add';

    constructor(private _http: HttpClient) { }

    appointExamination(consultTerm: ConsultTerm, id: any) {
        return  this._http.post<any>(`${this._url}/${id}`, consultTerm);  
    }
    
}