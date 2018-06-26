import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-table',
  templateUrl: './table.component.html',
  styleUrls: ['./table.component.css']
})
export class TableComponent implements OnInit {
  tableStyle = "table";
  toggle()
  {
    if(this.tableStyle==="")
    {
      this.tableStyle="table";
    }
    else if(this.tableStyle==="table")
    {
      this.tableStyle="";
    }
  }

  constructor() { }

  ngOnInit() {
  }


  PEOPLE=[{
      firstname: "Leanne",
      lastname: "Bret",
      email: "Sincere@april.biz",
      birthday: "1990-12-01"
    },
    {

        firstname: "Bomedo",
        lastname: "Okdnx",
        email: "Jodn@april.biz",
        birthday: "1992-12-01"
      
    },
    {
    firstname: "Janne",
    lastname: "Het",
    email: "Sincere@april.biz",
    birthday: "1980-12-01"
  },
  {

      firstname: "Yumedo",
      lastname: "Odnx",
      email: "Jodn@april.biz",
      birthday: "1992-12-01"
    
  }]

}
