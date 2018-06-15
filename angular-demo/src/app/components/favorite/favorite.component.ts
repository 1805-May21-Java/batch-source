import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-favorite',
  templateUrl: './favorite.component.html',
  styleUrls: ['./favorite.component.css']
})
export class FavoriteComponent implements OnInit {

  isFavorite: boolean = false;

  onClickChange(){
    this.isFavorite = !this.isFavorite;
  }

  constructor() { }

  ngOnInit() {
  }

  clazz: string = 'glyphicon glyphicon-star-empty'

  classClick(){
    if(this.clazz ==='glyphicon glyphicon-star-empty'){
      this.clazz = 'glyphicon glyphicon-star'
    } else {
      this.clazz = 'glyphicon glyphicon-star-empty';
    }
  }
}
