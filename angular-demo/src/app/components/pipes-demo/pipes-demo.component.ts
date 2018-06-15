import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-pipes-demo',
  templateUrl: './pipes-demo.component.html',
  styleUrls: ['./pipes-demo.component.css']
})
export class PipesDemoComponent implements OnInit {

  str: string = 'HeLlO';
  num: number = 5;
  day: Date = new Date();

  constructor() {}

  ngOnInit() {
  }

}
