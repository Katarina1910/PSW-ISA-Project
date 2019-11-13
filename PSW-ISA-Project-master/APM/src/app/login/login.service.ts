import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment';
import { Injectable } from '@angular/core';
import { Login } from './login';

@Injectable()
export class LoginService{
    _url = '';
    baseUrl = environment.apiUrl;
    constructor(private _http: HttpClient) {}

   enroll(login : Login) {
       return  this._http.post<any>(this._url, login);
    }

}