import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { User } from '../registration/user';
import { MedicalRecordd } from './medicalRecord';
import { Consult } from '../ConsultTermReport/Consult';

@Injectable({
    providedIn: 'root'
})
export class MedicalRecordService{
    
    public user : User;
    _url1 = 'http://localhost:8080/api/users/public';
    _url2 = 'http://localhost:8080/api/medicalRecord/get';
    _url3 = 'http://localhost:8080/api/medicalRecord/update';
    _url4 = 'http://localhost:8080/api/patient/getAll';
    _url5 = 'http://localhost:8080/api/ConsultTerm/editConsult';
    id: string;


    constructor(private _http: HttpClient) { }

    getUserProfile(id: number):Observable<any>{
        return this._http.get<User>(`${this._url1}/${id}`);
    }

    getMedicalRecord():Observable<any>{
        return this._http.get<MedicalRecordd>(`${this._url2}/${this.id}`);
    }

    getMedicalRecordById(id2: any):Observable<any>{
        return this._http.get<MedicalRecordd>(`${this._url2}/${id2}`);
    }

    editMedicalRecord(m:MedicalRecordd):Observable<any>{
        return this._http.put<void>(this._url3, m);
    }

    getConsults():Observable<any>{
        return this._http.get<Consult[]>(`${this._url4}/${this.id}`);
    }

    editConsults(consult: Consult):Observable<any>{
        return this._http.put<void>(this._url5, consult);
    }
}