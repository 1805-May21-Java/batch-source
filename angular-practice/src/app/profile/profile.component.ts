import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {

  constructor() { }

  ngOnInit() {
  }

  show: boolean = true;

  username: string = 'usr';
  pwd: string = 'password';
  firstname: string = 'Thomas';
  lastname: string = 'Jansen';
  email: string = 'my.email@gmail.com';

  toggleShow() {
    this.show = !this.show;
  }

}
