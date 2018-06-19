import { Component, OnInit } from '@angular/core';
// import { homedir } from 'os';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {

  btnTitle: String = "Show";
  condition: boolean;
  
  user =
    {name:'Joel',
    gender: 'Male',
    hometown: 'Fort Wayne'
    };

  constructor() { }

  ngOnInit() {
  }

  onShow(){
    this.btnTitle = "Hide";
    this.changeCondition();
  }

  onHide(){
    this.btnTitle = "Show";
    this.changeCondition();
  }

  changeCondition(){
    this.condition = !this.condition;
  }

}
