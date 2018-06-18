import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-highlight',
  templateUrl: './highlight.component.html',
  styleUrls: ['./highlight.component.css']
})
export class HighlightComponent implements OnInit {

  constructor() { }

  ngOnInit() {
  }
  highlightText(event:any) {
    event.target.style.backgroundColor = 'red';
  }
  unHighlightText(event:any) {
    event.target.style.backgroundColor = 'transparent';
  }
}