import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Diagnosis } from './diagnosis';

@Injectable({
    providedIn: 'root'
})

export class createDiagnosisCodeBookService{

    _url = 'http://localhost:8080/api/diagnosis';

    constructor(private _http: HttpClient) { }

    CreateDiagnosisCodeBook(diagnosis: Diagnosis){
        return this._http.post<any>(this._url, diagnosis);
    }
}