import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-select',
  templateUrl: './select.component.html',
  styleUrls: ['./select.component.css']
})
export class SelectComponent implements OnInit {

  constructor() { }

  ngOnInit() {
  }

 things = [
    {type:'animals'},
    {type:'colors'},
    {type:'days'}
  ];

 selectedThing;

 updateThing(type){
   this.selectedThing = type;
 }
 getSelectedThing() {
   switch(this.selectedThing) {
      case 'animals':
        return this.animals;
      case 'colors':
        return this.colors;
      case 'days':
        return this.days;
   }
 }

 animals = [
   {name: 'Elephant'},
   {name: 'Deer'},
   {name: 'Dog'},
   {name: 'Lion'}
 ];

 colors = [
  {name: 'Elepahnt'},
  {name: 'Deer'},
  {name: 'Dog'},
  {name: 'Lion'}
  ];

  days = [
    {name: 'Monday'},
    {name: 'Tuesday'},
    {name: 'Wednesday'},
    {name: 'Thursday'},
    {name: 'Friday'},
    {name: 'Saturday'},
    {name: 'Sunday'}
  ];

}
