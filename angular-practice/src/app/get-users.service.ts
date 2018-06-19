import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

import { Api} from './api-user';

@Injectable({
  providedIn: 'root'
})
export class GetUsersService {

  constructor(private http: HttpClient) { }

  url = "https://jsonplaceholder.typicode.com/users";

  getUsers():Observable<Api[]>{
    return this.http.get<Api[]>(this.url);
  }
}
