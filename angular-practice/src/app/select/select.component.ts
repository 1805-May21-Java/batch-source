import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-select',
  templateUrl: './select.component.html',
  styleUrls: ['./select.component.css']
})

export class SelectComponent implements OnInit {

  animals = ["Dog", "Cat", "Satanic Leaf-tailed Gecko", ":PartyParrot:"];
  colors = ["Red", "Blue", "Green", "Green", "Green", "Green",
  "Green", "Green", "Green", "Green", "Green", "Green", "Green",
  "Green", "Green", "Green", "Green", "Green", "Green", "Green",
  "Green", "Green", "Green", "Green", "Green", "Green", "Green",
  "Green", "Green", "Green", "Green", "Green", "Green", "Green",
  "Green", "Green", "Green", "Green", "Green", "Green", "Green"];
  days = ["Wednesday"];
  option: String;

  constructor() { }

  ngOnInit() {
  }

}