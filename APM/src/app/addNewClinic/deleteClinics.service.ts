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

    
    constructor(private _http: HttpClient) { }

    deleteClinics(id: number): Observable<void> {
       return  this._http.delete<void>(`${this._url}/${id}`);
    }

    getClinics():Observable<any> {
        return this._http.get<Clinic[]>(this._url2);
    }
}