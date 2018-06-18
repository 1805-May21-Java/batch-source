import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-highlightcomponent',
  templateUrl: './highlightcomponent.component.html',
  styleUrls: ['./highlightcomponent.component.css']
})
export class HighlightcomponentComponent implements OnInit {

  color: string = "red";
  constructor() { }

  ngOnInit() {
  }
  changeColorA(){
    this.color = "blue";
  }
  changeColorB(){
    this.color = "red";
  }
}
