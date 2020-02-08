import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { ConsultTerm } from '../consultTerm/consultTerm';
import { RequestForAbsence } from '../requestForAbsence/requestForAbsence';

@Injectable({
    providedIn: 'root'
})
export class DoctorWorkCalService{
    
    public consults: ConsultTerm[];
    _url = 'http://localhost:8080/api/ConsultTerm/getConsults';
    _url1 = 'http://localhost:8080/api/ConsultTerm/getConsult';
    _url2 = 'http://localhost:8080/api/RqForAbsence/getAll';
 
    constructor(private _http: HttpClient) { }

    getConsults(id: number, role: string):Observable<any> {
        return this._http.get<ConsultTerm[]>(`${this._url}/${id}/${role}`);
    }

    getConsult(id: any):Observable<any> {
        return this._http.get<ConsultTerm>(`${this._url1}/${id}`);
    }

    getVacations(id: any):Observable<any> {
        return this._http.get<RequestForAbsence[]>(`${this._url2}/${id}`);
    }
}