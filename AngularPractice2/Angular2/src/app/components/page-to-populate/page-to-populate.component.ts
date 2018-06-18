import { Component, OnInit } from '@angular/core';
import { WebServiceService } from '../../services/web-service.service';

@Component({
  selector: 'app-page-to-populate',
  templateUrl: './page-to-populate.component.html',
  styleUrls: ['./page-to-populate.component.css']
})
export class PageToPopulateComponent implements OnInit {

  people : string;
  constructor(private webService: WebServiceService) { }
  
  ngOnInit() {
    this.webService.getPeople()
    .subscribe(person=>this.people = person);
   
  }

}
