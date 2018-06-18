import { Component, OnInit } from '@angular/core';

import { User } from './user';
import { USERS} from './user-data';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})



export class ProfileComponent implements OnInit {

  constructor() { }

  ngOnInit() {
  }

  users = USERS;
  userVisible = true;

  toggleVisible(){
    this.userVisible = !this.userVisible;
  }
}