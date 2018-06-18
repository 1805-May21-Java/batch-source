import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {

  firstName: String;
  lastName: String;
  userName: String;
  ssn: Number;

  showUser: Boolean;

  constructor() { }

  toggleShowUser() {
    this.showUser = !this.showUser;
  }

  ngOnInit() {
    this.firstName = "John";
    this.lastName = "Smooth";
    this.userName = "SexyStroganoff123";
    this.ssn = 123456789;
  }

}
