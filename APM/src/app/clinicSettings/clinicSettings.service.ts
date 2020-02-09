import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { User } from '../registration/user';
import { Observable } from 'rxjs';
import { Clinic } from '../addNewClinic/clinic';

@Injectable({
    providedIn: 'root'
})

export class ClinicSettingsService{
    user: User = new User("","","","","","","","","","","","","");
    id: string = this.user.id;

    _url = 'http://localhost:8080/api/clinics/edit';
    _url1 = 'http://localhost:8080/api/clinics/get';

    constructor(private _http: HttpClient) { }



    editClinic(clinic: Clinic) : Observable<Clinic> {
        return  this._http.put<Clinic>(this._url, clinic);
    }

    getClinic(): Observable<any>{
        return this._http.get<Clinic>(`${this._url1}/${this.id}`);
    }

    
}
