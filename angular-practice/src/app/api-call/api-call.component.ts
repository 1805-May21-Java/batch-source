import { Component, OnInit } from '@angular/core';
import { Person } from '../Person';
import { PersonService } from '../person.service';


@Component({
  selector: 'app-api-call',
  templateUrl: './api-call.component.html',
  styleUrls: ['./api-call.component.css']
})
export class ApiCallComponent implements OnInit {
  people: Person[];
  isBootstrapTable: Boolean;

  constructor(private ps: PersonService) { }

  reformatTable(){
    this.isBootstrapTable = !this.isBootstrapTable;
  }

  ngOnInit() {
    this.ps.getPeople().subscribe(people => this.people = people);
    this.isBootstrapTable = false;
  }
}