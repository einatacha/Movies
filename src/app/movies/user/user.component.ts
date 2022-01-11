

import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { Observable, of } from 'rxjs';
import { catchError } from 'rxjs/operators';

import { UserService } from './../services/user.service';


@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.scss']

})


export class UserComponent implements OnInit {
title = 'user';

 public user : any;

  constructor(
    private userService: UserService,

  ) {}
//   onSelect(user){

// }
  ngOnInit(): void {
    this.listUser();
  }
  listUser(){
    this.userService.listUser().subscribe(data => {
      this.user = data;
      console.log("user", this.user);
    });
  }
}



