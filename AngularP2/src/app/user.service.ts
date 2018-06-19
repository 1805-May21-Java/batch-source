import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable, of } from 'rxjs';
import { User } from './user';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  private url: string;

  constructor(private http: HttpClient) {
      this.url="https://jsonplaceholder.typicode.com/users";
   }


  getPeople(): Observable<User[]>{
    return this.http.get<User[]>(this.url);
  }
}
