import { Component, OnInit } from '@angular/core';
import { ConfigService } from '../config.service';
import { Observable } from 'rxjs';
import { User } from '../user';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {

  constructor(private configService: ConfigService) { }
  users: User[];
  ngOnInit() {
      this.getUsers();
  }

  getUsers(){
      this.configService.getUsers().subscribe(
          (data) =>{this.users=data}
      );

  }
}
