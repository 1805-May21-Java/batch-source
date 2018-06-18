import { Component, OnInit } from '@angular/core';
import { Profile } from '../profile';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {
  constructor() { }

  ngOnInit() {
  }
  condition: boolean = true;
  profile: Profile ={name:"Devon", email:"gice101@gmail.com"};
  changeCondition()
  {
      this.condition = !this.condition;
  }
}
