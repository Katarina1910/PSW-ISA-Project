import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Diagnosis } from './diagnosis';

@Injectable({
    providedIn: 'root'
})
export class DeleteDiagnosisService{

    _url = 'http://localhost:8080/api/diagnosis/del';
    _url2 = 'http://localhost:8080/api/diagnosis/getAll';
    _url3 = 'http://localhost:8080/api/diagnosis/edit';
    
    constructor(private _http: HttpClient) { }

    deleteDiagnosis(id: number): Observable<void> {
       return this._http.delete<void>(`${this._url}/${id}`);
    }

    getDiagnosis():Observable<any> {
        return this._http.get<Diagnosis[]>(this._url2);
    }

    editDiagnosis(type: Diagnosis) : Observable<Diagnosis> {
        return  this._http.put<Diagnosis>(this._url3, type);
     }
}