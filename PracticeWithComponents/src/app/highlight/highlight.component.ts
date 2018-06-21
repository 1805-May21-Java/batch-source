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

  color: string = 'white';

  toggleColor() {
    if (this.color == 'white') {
      this.color = 'red';
    } else {
      this.color = 'white';
    }
  }

}