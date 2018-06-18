import { Component, OnInit } from '@angular/core';

import { User } from '../user';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {

  buttonLabel = "Hide";
  toggle = true;

  user: User = {
    id: 1,
    name: 'Sydney Mercier',
    dob: 'February 24, 1991'
  };

  constructor() { }

  ngOnInit() {
  }

  hideProfile(): void {
    this.toggle = !this.toggle;
    if (this.buttonLabel == "Hide") {
      this.buttonLabel = "Show";
    } else {
      this.buttonLabel = "Hide";
    }
  }

}
