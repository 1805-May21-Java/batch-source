import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Users } from './users';


@Injectable({
  providedIn: 'root'
})
export class ConfigserviceService {
  url: string = 'https://jsonplaceholder.typicode.com/users';
  constructor(private http: HttpClient) { }

  getUsers(): Observable<Users[]> {
    return this.http.get<Users[]>(this.url)
  }

  getUser(id: number): Promise<Users>{
    return this.http.get<Users>(this.url+'/'+id)
      .toPromise();
  }

}
