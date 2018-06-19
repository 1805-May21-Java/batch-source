import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-select',
  templateUrl: './select.component.html',
  styleUrls: ['./select.component.css']
})
export class SelectComponent implements OnInit {

  array;

  constructor() { }

  ngOnInit() {
  }

  animal(){
    this.array = ['dog', 'cat', 'squirrel', 'goat', 'cow'];
  }

  color(){
    this.array = ['red', 'blue', 'green', 'yellow'];
  }

  day(){
    this.array = ['Monday', 'Tuesday', 'Wednesday', 'Thursday', 'Friday', 'Saturday', 'Sunday'];
  }
}
