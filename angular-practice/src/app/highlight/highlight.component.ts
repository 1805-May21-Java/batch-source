import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-highlight',
  templateUrl: './highlight.component.html',
  styleUrls: ['./highlight.component.css']
})
export class HighlightComponent implements OnInit {

  isHighlighted: Boolean;

  constructor() { }

  highlight() {
    this.isHighlighted = true;
  }

  removeHighlight() {
    this.isHighlighted = false;
  }

  getColor(): String {
    if(this.isHighlighted){
      return "rgb(" + Math.floor(Math.random()*256)
      + "," + Math.floor(Math.random()*256)
      + "," + Math.floor(Math.random()*256) + ")";
    }
    else{
      return "white";
    }
  }
  ngOnInit() {
  }

}
