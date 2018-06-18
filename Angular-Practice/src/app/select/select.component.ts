import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms'

@Component({
  selector: 'app-select',
  templateUrl: './select.component.html',
  styleUrls: ['./select.component.css']
})
export class SelectComponent implements OnInit {
  toggle(str) {
    if (str == "animals") {
      this.showAnimals = true;
      this.showColors = false;
      this.showDays = false;

    } else if (str == "colors") {
      this.showAnimals = false;
      this.showColors = true;
      this.showDays = false;

    } else if (str == "days") {
      this.showAnimals = false;
      this.showColors = false;
      this.showDays = true;

    } else{
      this.showAnimals = false;
      this.showColors = false;
      this.showDays = false;
    }
  }


  showAnimals: boolean = false;
  animals = [
    "frog",
    "fish",
    "dog",
    "crab"
  ];

  showColors: boolean = false;
  colors = [
    "red",
    "green",
    "orange",
    "yellow"
  ];

  showDays: boolean = false;
  days = [
    "greenday",
    "tuesday",
    "monday",
    "wednesday"
  ];
  constructor() { }

  ngOnInit() {
  }

}
