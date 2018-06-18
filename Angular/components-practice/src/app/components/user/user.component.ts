import { Component, OnInit } from "@angular/core";
import { UserService } from "../../services/user.service";
import { apiUser } from "../../models/apiUser";
@Component({
  selector: "app-user",
  templateUrl: "./user.component.html",
  styleUrls: ["./user.component.css"]
})
export class UserComponent implements OnInit {
  users: apiUser[];
  isEmpty: boolean = true;

  constructor(private userService: UserService) {}

  ngOnInit() {}

  getUsers() {
    this.userService.getUsers().then(allUsers => {
      this.users = allUsers;
      this.isEmpty = false;
    });
  }
}
