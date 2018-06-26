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

   TYPE={Animals:['Deer','Monkey','Dog'],
   Days:['Monday', 'Tuesday'],
   Colors: ['Blue','Red']}

   myType=['Animal', 'Day', 'Color'];

  isAnimal=false;
  isColor=false;
  isDay=false;
  isType(value)
  {
    this.isAnimal=false;
    this.isColor=false;
    this.isDay=false;
    if(value==="Animal")
    {
      this.isAnimal=true;

    }else if(value==="Color"){
      this.isColor=true;

    }
    else if(value==="Day")
    {
      this.isDay=true;
    }

  }

 
}
