import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { RequestForPatReg } from './requestForPatReg';
import { Observable } from 'rxjs';
import { USER_ID_KEY } from '../config/local-storage-keys';
import { API_GET_USER } from '../config/api-paths';

@Injectable({
    providedIn: 'root'
})
export class UserService{
    
    _url = 'http://localhost:8080/api/users/public/add-user';
    _url1 = 'http://localhost:8080/api/users/public';

    constructor(private _http: HttpClient) { }

    enroll(requestForPatReg: RequestForPatReg) {
       return this._http.post<any>(this._url, requestForPatReg);
    }

    getUser(userId: number): Observable<any> {
        return this._http.get(`${this._url1}/${userId}`);
    }

    isUserLoggedIn(): boolean {
        return localStorage.getItem(USER_ID_KEY) != null;
    }

    public getUserInfo(): Observable<any> {
        const userId = localStorage.getItem(USER_ID_KEY);
        return this._http.get(`${API_GET_USER}/${userId}`);
    }
}