import { Component, OnInit } from '@angular/core';
import {UserService} from '../user.service';
import {Person} from '../person';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {

  people: Person[];
  constructor(private userService:UserService) { }

  getPeople (): void {

    this.userService.getPeople()
      .subscribe(people => this.people = people);
  }
  
  ngOnInit() {
    this.getPeople();
  }

}
