import { Component, OnInit } from '@angular/core';
import { Person } from '../Person';

@Component({
  selector: 'app-table',
  templateUrl: './table.component.html',
  styleUrls: ['./table.component.css']
})
export class TableComponent implements OnInit {

  people: Person[];
  isBootstrapTable: Boolean;

  constructor() { }

  reformatTable(){
    this.isBootstrapTable = !this.isBootstrapTable;
  }

  ngOnInit() {
    this.people = [
      {first: 'Banana', last: 'Smoothie', email: 'bananasmoothie@gmail.com', bday: new Date(1945, 3, 3)},
      {first: 'Cindy', last: 'Gorman', email: 'justgoingtobe@hotmail.com', bday: new Date(1985, 2, 25)},
      {first: 'This', last: 'Bird', email: 'bird123@gmail.com', bday: new Date(1990, 6, 28)}
    ];
    this.isBootstrapTable = false;
  }

}
