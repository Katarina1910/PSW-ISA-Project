import { Injectable } from '@angular/core';
import { Registration } from './registration';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment';





@Injectable()
export class RegistrationService{


    _url = '';
    baseUrl = environment.apiUrl;
    constructor(private _http: HttpClient) {}

   enroll(registration : Registration) {
       return  this._http.post<any>(this._url, registration);
    }

}