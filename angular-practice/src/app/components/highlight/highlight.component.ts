import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-highlight',
  templateUrl: './highlight.component.html',
  styleUrls: ['./highlight.component.css']
})
export class HighlightComponent implements OnInit {

  selectedClass: String = "";

  constructor() { }

  ngOnInit() {
  }

  onEnter(){
    this.selectedClass = "highlight";
  }

  onLeave(){
    this.selectedClass = "";
  }
}
