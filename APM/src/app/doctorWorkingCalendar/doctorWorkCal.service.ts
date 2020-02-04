import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { ConsultTerm } from '../consultTerm/consultTerm';

@Injectable({
    providedIn: 'root'
})
export class DoctorWorkCalService{
    
    public consults: ConsultTerm[];
    _url = 'http://localhost:8080/api/ConsultTerm/getConsults';

    
    constructor(private _http: HttpClient) { }

    getConsults(id: number, role: string):Observable<any> {
        return this._http.get<ConsultTerm[]>(`${this._url}/${id}/${role}`);
    }
}