import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';


interface User {
  id: number;
  name: string;
  username: string;
  email: string;
  address: {
    street: string;
    suite: string;
    city: string;
    zipcode: string;
    geo: {
      lat: string;
      lng: string;
    }
  }
  phone: string;
  website: string;
  company: {
    name:string;
    catchPhrase: string;
    bs: string;
  }
}

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {

  constructor(private http:HttpClient) { }

  ngOnInit() {
    this.http
      .get<User[]>("https://jsonplaceholder.typicode.com/users")
      .subscribe(
        (allUsers) => {this.users$ = allUsers; console.log(this.users$)}
      );
  }
  users$: User[];

  
}
