import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-table',
  templateUrl: './table.component.html',
  styleUrls: ['./table.component.css']
})
export class TableComponent implements OnInit {

  users = [
    {
      first: "Mei-Ling",
      last: "Zhou",
      birthday: "1968-24-4",
      email: "mlzhou@ecoantartica.com",
      quote: "It's up to us to protect the world."
    },
    {
      first: "Jamison",
      last: "Fawkes",
      birthday: "1993-16-8",
      email: "junkrat@junkertown.au",
      quote: "Time is money, friends, and we're almost flat broke!"
    },
    {
      first: "Reinhardt",
      last: "Wilhelm",
      birthday: "1947-4-3",
      email: "crusader7@aol.com",
      quote: "When all you have is a hammer, everyone else is a nail."
    },
    {
      first: "Angela",
      last: "Ziegler",
      birthday: "1981-12-2",
      email: "guardianangel@overwatch.com",
      quote: "Your personal guardian angel."
    }
  ];

  ugly: boolean;

  constructor() { 
    this.ugly = true;
  }

  ngOnInit() {
  }

  switch(){
    this.ugly = !this.ugly;
    console.log(this.users);
  }
}
