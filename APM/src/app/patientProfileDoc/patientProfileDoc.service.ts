import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { User } from '../registration/user';

@Injectable({
    providedIn: 'root'
})
export class PatientProfileDocService{

    _url = 'http://localhost:8080/api/users/public';

    constructor(private _http: HttpClient) { }

    getUserProfile(id: number):Observable<any>{
        return this._http.get<User>(`${this._url}/${id}`);
    }
}