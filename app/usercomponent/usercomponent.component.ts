import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { ConfigserviceService } from '../configservice.service';
import { Users } from '../users';



@Component({
  selector: 'app-usercomponent',
  templateUrl: './usercomponent.component.html',
  styleUrls: ['./usercomponent.component.css']
})
export class UsercomponentComponent implements OnInit {
  
  users: Users[];
  constructor(private configserviceService: ConfigserviceService) { }

  ngOnInit() {
  }

  getUsers(){
    this.configserviceService.getUsers()
      .subscribe(
        (allUsers) => {this.users = allUsers}
      )
  }

  
}
