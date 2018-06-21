import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-select',
  templateUrl: './select.component.html',
  styleUrls: ['./select.component.css']
})
export class SelectComponent implements OnInit {

  animalsArr: string[] = ["Eagle", "Seal", "Bear", "Wolf", "Gnats"];
  colorsArr: string[] = ["red", "blue", "purple", "teal", "maroon"];
  daysArr: string[] = ["Monday", "Tuesday", "Wednesday", "Thursday", "Friday"];

  currentArr: string[] = [];

  constructor() { }

  ngOnInit() {
  }

  setCurrentArray(arr: string[]) {
    this.currentArr = arr;
  }

}