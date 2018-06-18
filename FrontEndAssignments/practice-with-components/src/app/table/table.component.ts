import { Component, OnInit } from '@angular/core';

import { Person } from './person';
import { PEOPLE } from './person-data';

@Component({
  selector: 'app-table',
  templateUrl: './table.component.html',
  styleUrls: ['./table.component.css']
})
export class TableComponent implements OnInit {

  constructor() { }

  ngOnInit() {
  }

  people : Person[];
  class = '';

  generateTable(){
    this.people = PEOPLE;
  }

  changeClass(){
    this.class = this.class == '' ? 'table' : '';
  }

}
