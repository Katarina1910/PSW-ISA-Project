import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { appointedExamination } from './appointedExamination';

@Injectable()
export class AppointedExaminationsService{

  _url = 'http://localhost:8080/api/appointedExaminations';

    constructor(private http:HttpClient){
    }
  
    public findAll(): Observable<appointedExamination[]> {
      return this.http.get<appointedExamination[]>(this._url);
    }
    public findById(id:number): Observable<appointedExamination> {
      return this.http.get<appointedExamination>(`${this._url}/${id}`);
    }

    public save(appointedExamination:appointedExamination){
       return this.http.post<appointedExamination>(`${this._url}/add`,appointedExamination);
    }

    public editAppointedExamination(pregled:appointedExamination) {
        return this.http.put<appointedExamination>(`${this._url}/editAppointedExamination/${pregled.id}`,pregled);
    }

    public findByDoctor(id:number): Observable<appointedExamination[]> {
        return this.http.get<appointedExamination[]>("/api/appointedExaminations/getAppointed/"+id);
    }

    public findByPatient(id:number): Observable<appointedExamination[]> {
        return this.http.get<appointedExamination[]>("/api/appointedExaminations/getAppointedPatients/"+id);
    }
        

}