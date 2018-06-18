import { Component, OnInit } from '@angular/core';
import { User } from '../user';

@Component({
  selector: 'app-profilecomponent',
  templateUrl: './profilecomponent.component.html',
  styleUrls: ['./profilecomponent.component.css']
})
export class ProfilecomponentComponent implements OnInit {

  user: User = {
    username: 'hello123',
    email: 'helloworld@yahoo.com'
  }
  vis: boolean;
  constructor() { 
    
  }

  ngOnInit() {
  }
  showhide(){
    this.vis = !this.vis;
  }
}
