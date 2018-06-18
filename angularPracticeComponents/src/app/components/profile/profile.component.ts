import { Component, OnInit, ElementRef} from '@angular/core';
import { User } from 'src/app/profileUser';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {

  profileInfo : User = {
  firstname : "Kenny",
  lastname : "James",
  address : "94 McCormick",
  email : "batmanFan95@gmail.com",
  password : "redHood"};
  
  viewStatus: string = "Hide:"
  toggleView = true;

  constructor(private elRef:ElementRef) { elRef.nativeElement;}

  ngOnInit() {
    
  }

  toggle(){
    this.toggleView = !this.toggleView;
    if(this.toggleView === true){
      this.viewStatus = "Hide:"
    }else{
      this.viewStatus = "Show:";
    }
  }



}
