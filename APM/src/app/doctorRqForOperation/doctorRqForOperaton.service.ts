import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { DoctorRequestForOperation } from './doctorRqForOperaton';

@Injectable({
    providedIn: 'root'
})
export class DoctorRequestForOperationService{
    _url = 'http://localhost:8080/api/rqForOperation/doctor';

    constructor(private _http: HttpClient) { }

    addRequestForOperation(requestForOperation: DoctorRequestForOperation) {
       return  this._http.post<any>(this._url, requestForOperation);
    }
}