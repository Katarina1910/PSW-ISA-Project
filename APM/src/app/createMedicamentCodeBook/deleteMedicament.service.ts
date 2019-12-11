import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Medicament } from './medicament';

@Injectable({
    providedIn: 'root'
})
export class DeleteMedicamentService{
    _url = 'http://localhost:8080/api/medicaments/del';
    _url2 = 'http://localhost:8080/api/medicaments/getAll';
    _url3 = 'http://localhost:8080/api/medicaments/edit';


    
    constructor(private _http: HttpClient) { }

    deleteMedicaments(id: number): Observable<void> {
       return this._http.delete<void>(`${this._url}/${id}`);
    }

    getMedicaments():Observable<any> {
        return this._http.get<Medicament[]>(this._url2);
    }

    editMedicament(type: Medicament) : Observable<Medicament> {
        return  this._http.put<Medicament>(this._url3, type);
     }
}