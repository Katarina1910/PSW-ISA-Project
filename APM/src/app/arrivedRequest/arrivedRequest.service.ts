import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { User } from '../registration/user';
import { arrivedRequest } from './arrivedRequest.component';

@Injectable({
    providedIn: 'root'
})
export class arrivedRequestService{

    _url = 'http://localhost:8080/api/RqForPatientReg/getAll';

    constructor(private _http: HttpClient) { }

    getArrivedRequests(){
        return this._http.get<arrivedRequest[]>(this._url);
    }
}