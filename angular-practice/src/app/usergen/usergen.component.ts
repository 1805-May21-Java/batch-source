import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-usergen',
  templateUrl: './usergen.component.html',
  styleUrls: ['./usergen.component.css']
})
export class UsergenComponent implements OnInit {

  constructor(private http:HttpClient) {
    this.getUsers();
  }

  ngOnInit() {
  }

  users: user[] = [];

  url: string = 'https://jsonplaceholder.typicode.com/users';

  getUsers() {
    this.http.get<user[]>(this.url).subscribe((allusers) => {
      this.users = allusers;
    })
  }

}
