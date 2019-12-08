import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { ConsultType } from 'src/consultType/consultType';


@Injectable({
    providedIn: 'root'
})
export class DeleteConsultTypeService{
    _url = 'http://localhost:8080/api/ConsultType/del';
    _url2 = 'http://localhost:8080/api/ConsultType/getAll';

    
    constructor(private _http: HttpClient) { }

    deleteConsultType(id: number): Observable<void> {
       return  this._http.delete<void>(`${this._url}/${id}`);
    }

    getConsultTypes():Observable<any> {
        return this._http.get<ConsultType[]>(this._url2);
    }

}