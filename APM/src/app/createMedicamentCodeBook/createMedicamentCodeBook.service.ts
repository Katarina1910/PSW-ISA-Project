import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Medicament } from './medicament';

@Injectable({
    providedIn: 'root'
})

export class createMedicamentCodeBookService{

    _url = 'http://localhost:8080/api/medicaments';

    constructor(private _http: HttpClient) { }

    CreateMedicamentCodeBook(medicament: Medicament){
        return this._http.post<any>(this._url, medicament);
    }
}