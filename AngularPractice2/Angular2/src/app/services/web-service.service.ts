import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class WebServiceService {

  getPeople():Observable<string>{
    return this.http.get<string>(this.url);
  }

  url = "https://jsonplaceholder.typicode.com/users";
  constructor(private http: HttpClient) { }
}
