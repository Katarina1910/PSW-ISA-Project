import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Recipe } from '../ConsultTermReport/Recipe';

@Injectable({
    providedIn: 'root'
})
export class recipeValService{

    _url = 'http://localhost:8080/api/recipe/getAll';
    _url1 = 'http://localhost:8080/api/recipe/certify';

    constructor(private _http: HttpClient) { }

    getAll(id: any) {
        return  this._http.get<Recipe[]>(`${this._url}/${id}`);  
    }

    certify(id: any) {
        return  this._http.get<void>(`${this._url}/${id}`);  
    }
    
}