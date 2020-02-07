import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { User } from '../registration/user';
import { Observable } from 'rxjs';

@Injectable({
    providedIn: 'root'
})
export class DeleteNurseService{
    _url = 'http://localhost:8080/api/nurses/del';
    _url2 = 'http://localhost:8080/api/nurses/getAll';

    
    constructor(private _http: HttpClient) { }

    deleteNurse(email: string): Observable<void> {
       return  this._http.delete<void>(`${this._url}/${email}`);
    }

    getNurses():Observable<any> {
        return this._http.get<User[]>(this._url2);
    }
}