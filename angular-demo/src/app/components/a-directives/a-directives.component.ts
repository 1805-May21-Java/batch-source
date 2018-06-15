import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-a-directives',
  templateUrl: './a-directives.component.html',
  styleUrls: ['./a-directives.component.css']
})
export class ADirectivesComponent implements OnInit {

  colors: string[] = ['red', 'blue', 'green', 'yellow'];
  classes: string[] = ['bold', 'italic', 'highlight']
  isDisabled: boolean = true;
  selectedColor: string = 'color';
  selectedClass: string[];

  constructor() { }

  ngOnInit() {
  }

  enabler(){
    this.isDisabled = !this.isDisabled;
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
