import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-select',
  templateUrl: './select.component.html',
  styleUrls: ['./select.component.css']
})
export class SelectComponent implements OnInit {

  animalsArr: string[] = ["Cow", "Cat", "Dog", "Pig", "Goat"];
  colorsArr: string[] = ["blue", "red", "green", "yellow", "orange"];
  daysArr: string[] = ["Monday", "Tuesday", "Wednesday", "Thursday", "Friday"];

  currentArr: string[] = [];

  constructor() { }

  ngOnInit() {
  }

  setCurrentArray(arr: string[]) {
    this.currentArr = arr;
  }

}
