import { Component, OnInit } from '@angular/core';
import { People } from '../people';
@Component({
  selector: 'app-table',
  templateUrl: './table.component.html',
  styleUrls: ['./table.component.css']
})
export class TableComponent implements OnInit {

  constructor() { }

  ngOnInit() {
  }
  condition: boolean = true;
  peoples: People[] = [
    {firstName: "Devon", lastName:"Grissom",email: "my email",birthday: new Date("04,11,1990") },
    {firstName: "Sandra", lastName:"Grissom",email: "mom's email",birthday:new Date("05,26,1958") },
    {firstName: "Sara", lastName:"Grissom",email: "sister's email",birthday: new Date("06,26,1993") }
    ];

    changeCondition()
    {
        this.condition = !this.condition;
    }
}
