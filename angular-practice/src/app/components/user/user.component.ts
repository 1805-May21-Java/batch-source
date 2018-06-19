import { Component, OnInit } from '@angular/core';
import { GetUsersService } from '../../get-users.service';
import { Api } from '../../api-user';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {

  users: Api[];

  constructor(private data:GetUsersService) { }

  ngOnInit() {
    this.data.getUsers().subscribe(users => this.users = users);
  }

}
