import { Component, OnInit } from "@angular/core";
import { User } from "../../models/user";

@Component({
  selector: "app-profile",
  templateUrl: "./profile.component.html",
  styleUrls: ["./profile.component.css"]
})
export class ProfileComponent implements OnInit {
  user: User = {
    firstName: "Rafael",
    lastName: "Nadal",
    age: 32
  };

  shouldHide: boolean = false;
  buttonText: string = "show";

  hideUser() {
    this.shouldHide = !this.shouldHide;
    this.buttonText = this.buttonText === "hide" ? "show" : "hide";
  }

  constructor() {}

  ngOnInit() {}
}
