import { Component, OnInit } from "@angular/core";

@Component({
  selector: "app-select",
  templateUrl: "./select.component.html",
  styleUrls: ["./select.component.css"]
})
export class SelectComponent implements OnInit {
  animals: string[] = ["Cat", "Dog", "Elephant"];
  colors: string[] = ["Blue", "Green", "Yellow", "Red"];
  days: string[] = ["Friday", "Saturday", "Sunday"];
  options: string[];

  constructor() {}

  ngOnInit() {}

  selectOption(event: any) {
    event.preventDefault();
    if (document.getElementById("animals").checked) {
      this.options = this.animals;
    }
    if (document.getElementById("colors").checked) {
      this.options = this.colors;
    }
    if (document.getElementById("days").checked) {
      this.options = this.days;
    }
  }
}
