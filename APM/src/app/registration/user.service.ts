import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { RequestForPatReg } from './requestForPatReg';
import { Observable } from 'rxjs';
import { USER_ID_KEY, USER_ROLE_KEY } from '../config/local-storage-keys';
import { API_GET_USER } from '../config/api-paths';
import { User } from './user';

@Injectable({
    providedIn: 'root'
})
export class UserService{

    private user:User;

   role:String= localStorage.getItem(USER_ROLE_KEY);
 
    
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
        return (localStorage.getItem(USER_ID_KEY) != null);
    }

    isUserPatient(): boolean {
        if(this.isUserLoggedIn()) {
            this.user = JSON.parse(sessionStorage.getItem("user"));
            console.log(this.user.role);
            if(this.user.role==="PATIENT"){
                return true;
            }
            return false
        }
        return false;
    }

    isUserDoctor(): boolean {
        if(this.isUserLoggedIn()) {
            this.user = JSON.parse(sessionStorage.getItem("user"));
            console.log(JSON.stringify(this.user));
            if(this.user.role==="DOCTOR"){
                return true;
            }
            return false
        }

        return false;
    }

    


    public getUserInfo(): Observable<any> {
        const userId = localStorage.getItem(USER_ID_KEY);
        return this._http.get(`${API_GET_USER}/${userId}`);
    }
}