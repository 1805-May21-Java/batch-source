import { Component, OnInit } from '@angular/core';
import { GetUsersService } from 'src/app/get-users.service';
import { ApiUsers } from '../../apiUser';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {

  users : ApiUsers[];

  constructor(private data: GetUsersService) { }

  ngOnInit() {
    this.data.getPeople().subscribe(users => this.users = users);
  }




}
