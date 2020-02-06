import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { listOfDiagnosis } from '../listOfAllDiagnosis/listOfAllDiagnosis';
import { ConsultTerm } from '../consultTerm/consultTerm';

@Injectable({
    providedIn: 'root'
})

export class ConsultTermReportService{

    _url = 'http://localhost:8080/api/ConsultTerm/addConsultReport';
    id: string;

    constructor(private _http: HttpClient) { }

    addConsultTerm(consultTerm: ConsultTerm) {
        return  this._http.post<void>(this._url, consultTerm);  
     }

}