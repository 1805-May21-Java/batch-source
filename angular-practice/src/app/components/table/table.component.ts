import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-table',
  templateUrl: './table.component.html',
  styleUrls: ['./table.component.css']
})
export class TableComponent implements OnInit {

  people = [
    {firstName: 'Joel',
    lastName: 'Shellabarger',
    email: 'jgshellab@gmail.com',
    birthday: new Date("8/31/1995")},
    {firstName: 'Dave',
    lastName: 'Rodgers',
    email: 'dave@hotmail.com',
    birthday: new Date("6/24/1990")},
    {firstName: 'Mary',
    lastName: 'Poppins',
    email: 'maryp@yahoo.com',
    birthday: new Date("3/3/1942")},
    {firstName: 'Stan',
    lastName: 'Lee',
    email: 'stanlee@marvel.com',
    birthday: new Date("12/28/1922")}
  ]

  selectedClass: string[] = [];
  btnTitle = "unformat";

  constructor() { }

  ngOnInit() {
  }

  format(){
    this.selectedClass.push("table table-bordered table-striped");
    this.btnTitle="format";
  }

  unformat(){
    this.selectedClass = [];
    this.btnTitle="unformat";
  }

}
