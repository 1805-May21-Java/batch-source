import { Component, OnInit } from '@angular/core';
import { people } from './persons';

@Component({
  selector: 'app-table',
  templateUrl: './table.component.html',
  styleUrls: ['./table.component.css']
})
export class TableComponent implements OnInit {

  peeps: people[] = [
    { firstname: "Steph", lastname: "Curry", email: "steph@gmail.com", bday: new Date("1/01/1990") },
    { firstname: 'Kevin', lastname: 'Durant', email: 'kd@email.com', bday: new Date("1/01/1991") },
    { firstname: 'Klay', lastname: 'Thompson', email: 'klay@gmail.com', bday: new Date('1/01/1992') },
    { firstname: 'Draymond', lastname: 'Green', email: 'Dray@Bay.com', bday: new Date('1/01/1994') }
  ];

  style: boolean = true;

  constructor() { }

  ngOnInit() {
  }

  toggleStyle() {
    this.style = !this.style;
  }

}