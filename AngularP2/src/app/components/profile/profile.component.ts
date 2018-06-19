import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {

  hide: boolean;
  toggle: String;
  user = {
    name: 'the Person with no Name',
    weight: 142,
    height: 35,
    quote: "Madness takes its toll. Please have exact change."
  }
  constructor() {
    this.toggle = "Show";
    this.hide = false;
   }

  ngOnInit() {
  }

  switch(){
    if(this.hide){
      this.hide=false;
      this.toggle="Show";
    }
    else{
      this.hide = true;
      this.toggle="Hide";
    }
  }

}
