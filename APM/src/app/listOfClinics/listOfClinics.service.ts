import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { listOfClinics } from './listOfClinics';

@Injectable({
    providedIn: 'root'
})
export class listOfClinicsService{

    _url = 'http://localhost:8080/api/clinics/getAll';

    constructor(private _http: HttpClient) { }

    getListOfClinics():Observable<any>{
        return this._http.get<listOfClinics[]>(this._url);
    }
}