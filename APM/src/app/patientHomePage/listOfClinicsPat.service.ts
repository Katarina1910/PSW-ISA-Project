import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { listOfClinicsPat } from './listOfClinicsPat';

@Injectable({
    providedIn: 'root'
})
export class listOfClinicsPatService{

    _url = 'http://localhost:8080/api/clinics/getAll';

    constructor(private _http: HttpClient) { }

    getListOfClinics():Observable<any>{
        return this._http.get<listOfClinicsPat[]>(this._url);
    }
}