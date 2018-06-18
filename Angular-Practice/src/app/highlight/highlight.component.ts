import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-highlight',
  templateUrl: './highlight.component.html',
  styleUrls: ['./highlight.component.css']
})
export class HighlightComponent implements OnInit {
  color = "";

  setHighlight() {
    this.color = "#ffeda8";
  }

  removeHighlight() {
    this.color = "";
  }
  constructor() { }

  ngOnInit() {
  }

}
