import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
    providedIn: 'root'
})
export class requestExamination{

    _url = 'http://localhost:8080/api/';

    constructor(private _http: HttpClient) { }

    
}