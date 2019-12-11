import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { ConsultType } from 'src/consultType/consultType';

@Injectable({
    providedIn: 'root'
})
export class ConsultTypeService{
    _url = 'http://localhost:8080/api/ConsultType';

    constructor(private _http: HttpClient) { }

    addConsultType(consultType: ConsultType) {
       return  this._http.post<any>(this._url, consultType);
       
    }
}