import { Component, OnInit } from '@angular/core';
import { people } from './people';

@Component({
  selector: 'app-table',
  templateUrl: './table.component.html',
  styleUrls: ['./table.component.css']
})
export class TableComponent implements OnInit {

  peeps: people[] = [
    { firstname: "thomas", lastname: "Jansen", email: "Email.com", bday: new Date("3/01/2018") },
    { firstname: 'oli', lastname: 'phi', email: 'oliphiemail.com', bday: new Date("1/18/1994") },
    { firstname: 'jay', lastname: 'feldman', email: 'jf@gmail.com', bday: new Date('11/4/1992') },
    { firstname: 'christian', lastname: 'buhndi', email: 'chris@pratty.com', bday: new Date('3/12/1990') }
  ];

  style: boolean = true;

  constructor() { }

  ngOnInit() {
  }

  toggleStyle() {
    this.style = !this.style;
  }

}
