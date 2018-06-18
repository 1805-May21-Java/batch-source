import { Component, OnInit } from '@angular/core';
import { Select } from '../select';
@Component({
  selector: 'app-select',
  templateUrl: './select.component.html',
  styleUrls: ['./select.component.css']
})
export class SelectComponent implements OnInit {

  constructor() { }

  ngOnInit() {
  }
  value: string = '';
  selects: Select[] = [
      {animal: "cow", color: "white and black", day: "monday"},
      {animal: "cat", color: "calico", day:"tuesday"},
      {animal: "dog", color: "black", day:"saturday"}
  ];

  selectAnimal()
  {
      this.value = "animal";
  }

  selectColor()
  {
      this.value = "color";
  }

  selectDay()
  {
      this.value = "day";
  }
}
