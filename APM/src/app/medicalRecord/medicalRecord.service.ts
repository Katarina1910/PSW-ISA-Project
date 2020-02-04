import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { User } from '../registration/user';
import { MedicalRecordd } from './medicalRecord';

@Injectable({
    providedIn: 'root'
})
export class MedicalRecordService{
    
    public user : User;
    _url1 = 'http://localhost:8080/api/users/public';
    _url2 = 'http://localhost:8080/api/medicalRecord/get';


    constructor(private _http: HttpClient) { }

    getUserProfile(id: number):Observable<any>{
        return this._http.get<User>(`${this._url1}/${id}`);
    }

    getMedicalRecord(id: any):Observable<any>{
        return this._http.get<MedicalRecordd>(`${this._url2}/${id}`);
    }
}