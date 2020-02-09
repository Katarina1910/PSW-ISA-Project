import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { User } from '../registration/user';
import { Observable } from 'rxjs';

@Injectable({
    providedIn: 'root'
})
export class DeleteDoctorService{
    _url = 'http://localhost:8080/api/doctors/del';
    _url2 = 'http://localhost:8080/api/doctors/getAll';

    
    constructor(private _http: HttpClient) { }

    deleteDoctor(id:number): Observable<void> {
       return  this._http.delete<void>(`${this._url}/${id}`);
    }

    getDoctors():Observable<any> {
        return this._http.get<User[]>(this._url2);
    }
}