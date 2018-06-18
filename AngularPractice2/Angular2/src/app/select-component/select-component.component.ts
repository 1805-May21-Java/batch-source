import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-select-component',
  templateUrl: './select-component.component.html',
  styleUrls: ['./select-component.component.css']
})
export class SelectComponentComponent implements OnInit {

  showSelected(arrayName: string){
    document.getElementById("animal").setAttribute("hidden","true");
    document.getElementById("color").setAttribute("hidden","true");
    document.getElementById("day").setAttribute("hidden","true");
    document.getElementById(arrayName).removeAttribute("hidden");
  }
  
  animals = ["a tiny worm","cats","the animal that has no name","T-Rex","a calm parot"];
  colors = ["mediumaquamarine","lightgoldenrodyellow","slateblue","olivedrab"];
  days = ["Wednesday","Arbor Day","March 12th"];
  constructor() { }

  ngOnInit() {
  }

}
