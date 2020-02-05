import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { User } from '../registration/user';
import { Observable } from 'rxjs';

@Injectable({
    providedIn: 'root'
})

export class ClinicCenterAdminProfilePageService{

    _url = 'http://localhost:8080/api/users/edit';

    constructor(private _http: HttpClient) { }

    editUsers(user: User) : Observable<User> {
        return  this._http.put<User>(this._url, user);
    }
}