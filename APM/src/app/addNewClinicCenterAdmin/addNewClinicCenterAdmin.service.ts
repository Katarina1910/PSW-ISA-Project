import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { ClinicCenterAdmin } from './ClinicCenterAdmin';

@Injectable({
    providedIn: 'root'
})

export class AddClinicCenterAdminService{
    
    _url = 'http://localhost:8080/api/clinicCenterAdmins';
    _url2 = 'http://localhost:8080/api/clinics/getAll';

    constructor(private _http: HttpClient) { }

    addNewClinicCenterAdmin(admin: ClinicCenterAdmin){
        return this._http.post<any>(this._url, admin);
    }
}