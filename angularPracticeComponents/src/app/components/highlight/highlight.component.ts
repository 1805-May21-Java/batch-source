import { Component, OnInit, ElementRef } from '@angular/core';
//import { User } from '/profileUser';

@Component({
  selector: 'app-highlight',
  templateUrl: './highlight.component.html',
  styleUrls: ['./highlight.component.css']
})
export class HighlightComponent implements OnInit {

  constructor(private elRef:ElementRef) { elRef.nativeElement;}
  //constructor() { }

  ngOnInit() {
  }

  changeOnOver(){
  //  this.elRef.style.backgroundColor = "blue";
    let divTag = this.elRef.nativeElement.getElementsByTagName('p')[0];
    divTag.style.backgroundColor = "lightblue";
  }

  changeOnLeave(){
    let divTag = this.elRef.nativeElement.getElementsByTagName('p')[0];
    divTag.style.backgroundColor = "greenyellow";
  }

}
