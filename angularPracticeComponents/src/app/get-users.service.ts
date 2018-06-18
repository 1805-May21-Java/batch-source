import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

import { ApiUsers} from './apiUser';



@Injectable({
  providedIn: 'root'
})
export class GetUsersService {

  private userUrl = "https://jsonplaceholder.typicode.com/users";

  constructor(private http: HttpClient) { }

  getPeople():Observable<ApiUsers[]>{
    return this.http.get<ApiUsers[]>(this.userUrl);
  }
 
}