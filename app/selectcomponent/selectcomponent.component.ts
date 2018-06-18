import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-selectcomponent',
  templateUrl: './selectcomponent.component.html',
  styleUrls: ['./selectcomponent.component.css']
})
export class SelectcomponentComponent implements OnInit {
  animals: string[] = ['panther', 'zebra', 'hippo', 'turtle'];
  colors: string[] = ['red', 'blue', 'purple', 'green'];
  days: string[] =['Monday', 'Sunday', 'Wednesday', 'Friday'];
  isanimal: boolean = false;
  iscolor: boolean = false;
  isday: boolean = false;
  constructor() { }

  ngOnInit() {
  }

  animallist(){
    this.isanimal = true;
    this.iscolor = false;
    this.isday = false;
  }
  colorlist(){
    this.isanimal = false;
    this.iscolor = true;
    this.isday = false;
  }
  daylist(){
    this.isanimal = false;
    this.iscolor = false;
    this.isday = true;
  }

}
