import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Clinic } from './clinic';

@Injectable({
    providedIn: 'root'
})
export class DeleteClinicsService{
    _url = 'http://localhost:8080/api/clinics/del';
    _url2 = 'http://localhost:8080/api/clinics/getAll';
    _url3 = 'http://localhost:8080/api/clinics/edit';
    _url4 = 'http://localhost:8080/api/clinics/rateClinic';

    
    constructor(private _http: HttpClient) { }

    deleteClinics(id: number): Observable<void> {
       return  this._http.delete<void>(`${this._url}/${id}`);
    }

    getClinics():Observable<any> {
        return this._http.get<Clinic[]>(this._url2);
    }

    editClinic(clinic: Clinic) : Observable<Clinic> {
        return  this._http.put<Clinic>(this._url3, clinic);
    }

    rateClinic(clin: Clinic, rate: any) {
        return this._http.put<Clinic>(`${this._url4}/${rate}`, clin);
    }
}