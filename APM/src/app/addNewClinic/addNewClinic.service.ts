import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Clinic } from './clinic';

@Injectable({
    providedIn: 'root'
})

export class AddNewClinicService{

    _url = 'http://localhost:8080/api/clinics';

    constructor(private _http: HttpClient) { }

    addNewClinic(clinic: Clinic){
        return this._http.post<any>(this._url, clinic);
    }
}