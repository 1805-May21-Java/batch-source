import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-s-directives',
  templateUrl: './s-directives.component.html',
  styleUrls: ['./s-directives.component.css']
})
export class SDirectivesComponent implements OnInit {

  constructor() { }

  ngOnInit() {
  }

  condition: boolean = true;

  changeCondition(){
    this.condition = !this.condition;
  }

  courses = [
    {id:5,
    name:'English'}, 
    {id:23,
    name: 'Physics'},
    {id:42,
    name:'Japanese'}];


    time: string = 'day?';

    changeDay(){
      this.time='day';
    }

    changeNight(){
      this.time='night'
    }

}
