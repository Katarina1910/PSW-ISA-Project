import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { User } from '../registration/user';

@Injectable({
    providedIn: 'root'
})
export class AddNurseService{
    
    _url = 'http://localhost:8080/api/nurses';

    constructor(private _http: HttpClient) { }

    addNurse(nurse: User) {
       return  this._http.post<any>(this._url, nurse);
    }
}