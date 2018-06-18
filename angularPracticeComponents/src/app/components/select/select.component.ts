import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-select',
  templateUrl: './select.component.html',
  styleUrls: ['./select.component.css']
})
export class SelectComponent implements OnInit {

  animals : string[] = ["dog", "cat", "hamster"];

  colors : string[] = ["red", "blue", "green", "brown"];

  days : string[] = ["monday", "tuesday", "wednesday", "thursday"];


  items : string[];

  display : boolean = false;



  constructor() { }

  ngOnInit() {
  }

  selectedAnimals(){
    this.display = true;
    this.items = this.animals;
  }

  selectedColor(){
    this.display = true;
    this.items = this.colors;
  }

  selectedDays(){
    this.display = true;
    this.items = this.days;
  }

}
