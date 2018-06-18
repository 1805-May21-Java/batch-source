import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

import { Observable, of } from 'rxjs';

import { Person } from './Person';

@Injectable({
  providedIn: 'root'
})
export class PersonService {

  private URL = "https://jsonplaceholder.typicode.com/users";

  constructor(private http: HttpClient) { }

  getPeople(): Observable<Person[]>{
    return this.http.get<Person[]>(this.URL);
  }

  getPerson(num: number): Observable<Person>{
    const newURL = `${this.URL}/${num}`;
    return this.http.get<Person>(newURL);
  }
}
