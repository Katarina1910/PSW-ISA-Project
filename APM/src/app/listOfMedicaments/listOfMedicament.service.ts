import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { listOfMedicaments } from './listOfMedicament';

@Injectable({
    providedIn: 'root'
})
export class listOfMedicamentService{

    _url = 'http://localhost:8080/api/medicaments/getAll';

    constructor(private _http: HttpClient) { }

    getListOfMedicament():Observable<any>{
        return this._http.get<listOfMedicaments[]>(this._url);
    }
}