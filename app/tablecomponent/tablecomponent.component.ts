import { Component, OnInit } from '@angular/core';
import { Person } from '../person'

@Component({
  selector: 'app-tablecomponent',
  templateUrl: './tablecomponent.component.html',
  styleUrls: ['./tablecomponent.component.css']
})
export class TablecomponentComponent implements OnInit {

  
  Jay: Person = {
    firstname: 'jay',
    lastname: 'craft',
    email: 'jaycraft@yahoo.com',
    birthday: new Date('1985-06-24')
  }
  Maria: Person = {
    firstname: 'maria',
    lastname: 'scarlett',
    email: 'scarlettM@gmail.com',
    birthday: new Date('1999-01-13')
  }
  Alice: Person = {
    firstname: 'alice',
    lastname: 'doll',
    email: 'alicemagic@magic.com',
    birthday: new Date('2000-02-29')
  }
  Mark: Person = {
    firstname: 'mark',
    lastname: 'markannon',
    email: 'markmark@yahoo.com',
    birthday: new Date('1990-12-24')
  }
  people: Person[] = [this.Jay, this.Maria, this.Alice, this.Mark];
  toggle1: boolean = false;
  toggle2: boolean = true;
  constructor() { }

  ngOnInit() {
  }
  toggle(){
    this.toggle1 = !this.toggle1;
    this.toggle2 = !this.toggle2;
  }
}
