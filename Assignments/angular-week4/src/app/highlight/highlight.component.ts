import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-highlight',
  templateUrl: './highlight.component.html',
  styleUrls: ['./highlight.component.css']
})
export class HighlightComponent implements OnInit {

  constructor() { }

  changeBackground(event)
  {
  
    event.target.style.backgroundColor='yellow';
  }

  changeBackgroundBack(event)
  {
  
    event.target.style.backgroundColor='lightblue';
  }
  ngOnInit() {
  }

}
