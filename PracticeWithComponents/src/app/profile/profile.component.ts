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


  firstname: string = 'Stephen';
  lastname: string = 'Curry';
  email: string = 'bay@gmail.com';

  toggleShow() {
    this.show = !this.show;
  }

}