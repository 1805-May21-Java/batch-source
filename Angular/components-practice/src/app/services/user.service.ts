import { Injectable } from "@angular/core";
import { HttpClient } from "@angular/common/http";
import { apiUser } from "../models/apiUser";

@Injectable({
  providedIn: "root"
})
export class UserService {
  url: string = "https://jsonplaceholder.typicode.com/users";
  constructor(private http: HttpClient) {}

  getUsers(): Promise<apiUser[]> {
    return this.http.get<apiUser[]>(this.url).toPromise();
  }
}
