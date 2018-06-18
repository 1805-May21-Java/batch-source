import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-profile-display',
  templateUrl: './profile-display.component.html',
  styleUrls: ['./profile-display.component.css']
})
export class ProfileDisplayComponent implements OnInit {


  user = {
    name :"Hank",
    species: "Giraffe",
    height: 13.3,
    lastFoodEaten: "Fig",
    url: "https://kids.nationalgeographic.com/content/dam/kids/photos/animals/Mammals/A-G/giraffe-baby.ngsversion.1411232159925.jpg"
  } 

  showHide = "Hide"

  showOrHide(){
    let info = document.getElementById("info")
    console.log(info.getAttribute("hidden"));
    if(info.getAttribute("hidden")){
      //hidden true, make it true
      info.removeAttribute("hidden");
      this.showHide = "Hide";

    }else{
      //hidden false
      info.setAttribute("hidden","true");
      this.showHide = "Show";    }
  }

  constructor() { }

  ngOnInit() {
  }

}
