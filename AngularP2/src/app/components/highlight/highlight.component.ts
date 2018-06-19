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

  highlight($event){
    $event.currentTarget.setAttribute("style","background-color:#66ccff");
  }

  unhighlight($event){
    $event.currentTarget.removeAttribute("style");
  }


}
