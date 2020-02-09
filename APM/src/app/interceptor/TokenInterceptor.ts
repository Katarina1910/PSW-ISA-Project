import { Injectable } from '@angular/core';
import {
  HttpRequest,
  HttpHandler,
  HttpEvent,
  HttpInterceptor,
  HttpClient
} from '@angular/common/http';
import { Observable } from 'rxjs';
import { USER_TOKEN_KEY } from '../config/local-storage-keys';

@Injectable()
export class AddTokenInterceptor implements HttpInterceptor {
  
  constructor(private http: HttpClient){
  }
  
  intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
    console.log(localStorage.getItem(USER_TOKEN_KEY))
    let jsonReq: HttpRequest<any> = req.clone({
      setHeaders:{
        Authorization : `Bearer ${localStorage.getItem(USER_TOKEN_KEY)}`
      }
    });
    
    return next.handle(jsonReq);
  }
  
}