import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { listOfDiagnosis } from './listOfAllDiagnosis';

@Injectable({
    providedIn: 'root'
})
export class listOfDiagnosisService{

    _url = 'http://localhost:8080/api/diagnosis/getAll';

    constructor(private _http: HttpClient) { }

    getListOfDiagnosis():Observable<any>{
        return this._http.get<listOfDiagnosis[]>(this._url);
    }
}