import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Login } from './login';
import { User } from '../registration/user';

@Injectable({
    providedIn: 'root'
})
export class LoginService{
    _url = 'http://localhost:8080/api/users/login';
    constructor(private _http: HttpClient){ }

    login(login: Login){
        return this._http.post<any>(this._url,login);
    }
}