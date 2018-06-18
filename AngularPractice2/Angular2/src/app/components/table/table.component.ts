import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-table',
  templateUrl: './table.component.html',
  styleUrls: ['./table.component.css']
})
export class TableComponent implements OnInit {

  buttonText="Uglify";

  bool = true;
  tableClass="container table";
  headerClass="thead-dark";

  changeTable(){
    if(this.buttonText === "Uglify"){
      this.bool = false;
      this.buttonText="Beautify"
    }else{
     this.bool = true;
     this.buttonText="Uglify"
    }
  }

  people = [
    {
    firstName:"Tommy",
    lastName:"Pickles",
    email:"ababysgottado@aol.com",
    birthday:'1990-9-11'},
    {
      firstName:"Chuckie",
      lastName:"Finster",
      email:"Imgladwereafamily@aol.com",
      birthday:"1989-4-15"
    },
    {
      firstName:"Angelica",
      lastName:"Pickles",
      email:"youstupidbabies@aol.com",
      birthday:"1988-5-12"
    },
    {
      firstName:"Lil",
      lastName:"DeVille",
      email:"gettingstunghurts@aol.com",
      birthday: "1990-3-31"
    },
    {
      firstName:"Phil",
      lastName:"DeVille",
      email:"whatsthefunofgettinggarbade@aol.com",
      birthday:"1990-3-31"
    }
  ]

  constructor() { }

  ngOnInit() {
  }

}
