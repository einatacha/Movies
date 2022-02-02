import { ActivatedRoute } from '@angular/router';
import { FormBuilder } from '@angular/forms';
import { Component, OnInit } from '@angular/core';

import { UserService } from './../services/user.service';

@Component({
  selector: 'app-userId',
  templateUrl: './user.id.component.html',
  styleUrls: ['./user.id.component.scss'],
})
export class UserIdComponent implements OnInit {
  title = 'userId';

  public userId: any;

  constructor(
    private userService: UserService,
    private route: ActivatedRoute
  ) {}

  ngOnInit(): void {
    this.userId = this.route.snapshot.params['id'];
    this.getById();
  }

  getById() {
    this.userService.getById(this.userId).subscribe((data) => {
      this.userId = data;
      console.log('funciona', this.userId);
    });
  }
}
