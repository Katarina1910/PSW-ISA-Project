import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { listOfPatients } from './listOfPatients';

@Injectable({
    providedIn: 'root'
})
export class listOfPatientsService{

    _url = 'http://localhost:8080/api/patient/getAll';
    urll = 'http://localhost:8080/api/users';

    constructor(private _http: HttpClient) { }

    getListOgPatients():Observable<any>{
        return this._http.get<listOfPatients[]>(this.urll);
    }
}