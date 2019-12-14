import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { User } from '../registration/user';
import { Observable } from 'rxjs';
import { Clinic } from '../addNewClinic/clinic';
import { ClinicAdmin } from './ClinicAdmin';

@Injectable({
    providedIn: 'root'
})
export class AddClinicAdminService{
    _url = 'http://localhost:8080/api/clinicAdmins';
    _url2 = 'http://localhost:8080/api/clinics/getAll';

    constructor(private _http: HttpClient) { }

    addClinicAdmin(admin: ClinicAdmin) {
       return  this._http.post<any>(this._url, admin);
    }

    
    getClinics():Observable<any> {
        return this._http.get<Clinic[]>(this._url2);
    }
}