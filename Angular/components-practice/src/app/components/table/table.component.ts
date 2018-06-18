import { Component, OnInit } from "@angular/core";
import { Person } from "../../models/person";
@Component({
  selector: "app-table",
  templateUrl: "./table.component.html",
  styleUrls: ["./table.component.css"]
})
export class TableComponent implements OnInit {
  people: Person[] = [
    {
      firstName: "Mitchell",
      lastName: "Korb",
      email: "mkorb0@si.edu",
      birthday: new Date("10/25/1993")
    },
    {
      firstName: "Jammie",
      lastName: "Borrow",
      email: "jborrow1@com.com",
      birthday: new Date("06/15/1985")
    },
    {
      firstName: "Elita",
      lastName: "Kenyon",
      email: "ekenyon3@cbslocal.com",
      birthday: new Date("06/05/1989")
    },
    {
      firstName: "Kristy",
      lastName: "Cotgrave",
      email: "kcotgrave9@over-blog.com",
      birthday: new Date("12/03/1991")
    }
  ];

  buttonText: string = "Style with bootstrap";
  styleWithBootstrap: boolean = false;
  currentClasses: {};

  constructor() {}

  ngOnInit() {}

  changeStyle() {
    this.styleWithBootstrap = !this.styleWithBootstrap;
    this.buttonText =
      this.buttonText === "Style with bootstrap"
        ? "Remove bootstrap styling"
        : "Style with bootstrap";
    this.currentClasses = {
      "bg-dark": this.styleWithBootstrap,
      "text-white": this.styleWithBootstrap
    };
  }
}
