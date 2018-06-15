import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-clicker',
  templateUrl: './clicker.component.html',
  styleUrls: ['./clicker.component.css']
})
export class ClickerComponent implements OnInit {

  count = 0;
  //incrementor = 5;
  incrementors = [5,10,15];

  constructor() { }

  ngOnInit() {
  }

  increment(inc: number){
    this.count += inc;
  }

}
