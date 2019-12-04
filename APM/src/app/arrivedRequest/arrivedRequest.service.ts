import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { arrivedRequest } from './arrivedRequest.component';
import { Observable } from 'rxjs';
import { User } from '../registration/user';

@Injectable({
    providedIn: 'root'
})
export class arrivedRequestService{

    _url = 'http://localhost:8080/api/RqForPatientReg/getAll';

    constructor(private _http: HttpClient) { }

    getArrivedRequests():Observable<any>{
        return this._http.get<arrivedRequest[]>(this._url);
    }

}