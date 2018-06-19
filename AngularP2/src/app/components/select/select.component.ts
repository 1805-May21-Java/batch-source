import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-select',
  templateUrl: './select.component.html',
  styleUrls: ['./select.component.css']
})
export class SelectComponent implements OnInit {

  animals: String[] = ["cat", "dog", "mouse", "parrot", "fish"];
  colors: String[] = ["blue", "red", "green", "black", "white"];
  days: String[] = ["monday", "tuesday", "wednesday", "thrusday", "friday"];
  classes: string[] = ['bold', 'italic', 'highlight'];
  selectedClass: String[];
  selected: String;

  constructor() { }

  ngOnInit() {
  }

  setVal(str){
    this.selected=str;
    console.log(this.selected);
  }

  addClass(event){
    this.selectedClass = [];
    let values = event.target.options;
    let opt;

    for(let i=0; i< values.length; i++){
      opt = values[i];

      if(opt.selected){
        this.selectedClass.push(opt.text)
      }
    }

}

}
