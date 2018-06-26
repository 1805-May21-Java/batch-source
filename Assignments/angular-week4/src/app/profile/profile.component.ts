import { Component, OnInit } from '@angular/core';
import { User } from '../user';
import {USERS} from '../user_data'
@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {

  constructor() { }

  ngOnInit() {
  }

  all_users=USERS;
  isClicked: boolean = true;
  
  toggleShow(){
    this.isClicked=!this.isClicked;
  }
}
