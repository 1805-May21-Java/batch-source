import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {

  user = {
    src: "https://pbs.twimg.com/profile_images/445963359410589696/MRmLf218_400x400.jpeg",
    name: "Green Giant",
    email: "GreenGiant@bgfoods.com",
    phone: "(410) 943-4933",
    location: "Hurlock, MD"
  }
  show: boolean = true;
  buttonText = "hide";
  toggleText() {
    this.show = !this.show;
    if(this.show) {
      this.buttonText = "hide";
    } else {
      this.buttonText = "show";
    }
  }
  constructor() { }

  ngOnInit() {
  }

}
