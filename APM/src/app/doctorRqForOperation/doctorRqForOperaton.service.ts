import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { DoctorRequestForOperation } from './doctorRqForOperaton';
import { Observable } from 'rxjs';

@Injectable({
    providedIn: 'root'
})
export class DoctorRequestForOperationService{
    _url = 'http://localhost:8080/api/rqForOperation/doctor';
    _url1 = 'http://localhost:8080/api/rqForOperation/getAll';

    constructor(private _http: HttpClient) { }

    addRequestForOperation(requestForOperation: DoctorRequestForOperation) {
       return  this._http.post<any>(this._url, requestForOperation);
    }

    getRequests() : Observable<any>{
        return  this._http.get(this._url1);
     }
}