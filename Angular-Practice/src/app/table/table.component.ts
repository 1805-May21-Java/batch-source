import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-table',
  templateUrl: './table.component.html',
  styleUrls: ['./table.component.css']
})
export class TableComponent implements OnInit {
  styleOn = false;

  toggle() {
    this.styleOn = !this.styleOn;
  }
  
  people = [
    {
      name: "Troy Bolton",
      email: "T.Bolton@email.com",
      birthday: "1990-03-10"
    }, {
      name: "Sharpay Evans",
      email: "S.Evans@email.comm",
      birthday: "1990-09-19"
    }, {
      name: "Ryan Evans",
      email: "R.Evans@email.com",
      birthday: "1990-09-19"
    }, {
      name: "Gabriella Montez",
      email: "G.Montez@email.com",
      birthday: "1990-06-09"
    }, {
      name: "Chad Danforth",
      email: "C.Danforth@email.com",
      birthday: "1989-02-21"
    }, {
      name: "Kelsi Nielsen",
      email: "K.Nielsen@email.com",
      birthday: "1990-11-23"
    }
  ]

  constructor() { }

  ngOnInit() {
  }

}
