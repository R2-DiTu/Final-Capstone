import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Login } from './login';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class LoginService {
baseUrl:string="http://localhost:9292/login";

  constructor(public http:HttpClient) { }

  loadAllLoginInfo():Observable<Login[]>{
    return this.http.get<Login[]>(`${this.baseUrl}/find`);
  }


  
}
