import { HttpBackend, HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Movies } from './movies';

@Injectable({
  providedIn: 'root'
})
export class MoviesService {
  baseUrl:string="http://localhost:9393/movies";

  constructor(public http:HttpClient) { }

  loadAllMoviesInfo():Observable<Movies[]>{
    return this.http.get<Movies[]>(`${this.baseUrl}/find`);
  }

  storeMovie(movie:any):Observable<string>{
    return this.http.post(`${this.baseUrl}/store`, Movies,{responseType:'text'});
  }
}
