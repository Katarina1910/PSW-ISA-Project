import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { ConsultType } from './consultType';


@Injectable({
    providedIn: 'root'
})
export class DeleteConsultTypeService{
    _url = 'http://localhost:8080/api/ConsultType/del';
    _url2 = 'http://localhost:8080/api/ConsultType/getAll';
    _url3 = 'http://localhost:8080/api/ConsultType/edit';

    
    constructor(private _http: HttpClient) { }

    deleteConsultType(id: number): Observable<void> {
       return  this._http.delete<void>(`${this._url}/${id}`);
    }

    getConsultTypes():Observable<any> {
        return this._http.get<ConsultType[]>(this._url2);
    }
    editCOnsutType(type: ConsultType) : Observable<ConsultType> {
        return  this._http.put<ConsultType>(this._url3, type);
     }

}