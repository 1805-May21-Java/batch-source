import { Component, OnInit } from '@angular/core';
import { User} from 'src/app/profileUser';

@Component({
  selector: 'app-table',
  templateUrl: './table.component.html',
  styleUrls: ['./table.component.css']
})
export class TableComponent implements OnInit {


  user1 : User = {
    firstname : "kenny",
    lastname : "James",
    address : "94 McCormick",
    email : "batmanFan95@gmail.com",
    password : "redHood"};
  
  user2 : User = {
    firstname : "tim",
    lastname : "carter",
    address : "155 Transit",
    email : "googleRocks5ever@gmail.com",
    password : "search"};

  user3: User =  {
      firstname : "sylvia",
      lastname : "jimenez",
      address : "5th and G Avenue",
      email : "syl58@gmail.com",
      password : "magic"};

  people: User[] = [this.user1, this.user2, this.user3];

  wellFormat = false;

  constructor() { }

  ngOnInit() {
  }

  displayFormat(){
    this.wellFormat = !this.wellFormat;
  }
  



}
