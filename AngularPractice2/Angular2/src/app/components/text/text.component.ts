import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-text',
  templateUrl: './text.component.html',
  styleUrls: ['./text.component.css']
})
export class TextComponent implements OnInit {


  highlightParagraph(event){
    event.currentTarget.setAttribute("style","background-color: green");
  }
  
  unhighlight(event){
    event.currentTarget.setAttribute("style","background-color: white");
  }
  
  constructor() { }

  ngOnInit() {
    let paragraphs = document.getElementsByTagName("p");
  for(let i=0;i<paragraphs.length;i++){
    let paragraph = paragraphs[i];
    
  }
  }

}
