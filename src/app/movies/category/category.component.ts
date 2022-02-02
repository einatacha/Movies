import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { Observable, of } from 'rxjs';
import { catchError } from 'rxjs/operators';

import { CategoryService } from './../services/category.service';

@Component({
  selector: 'app-category',
  templateUrl: './category.component.html',
  styleUrls: ['./category.component.scss'],
})
export class CategoryComponent implements OnInit {
  title = 'category';

  public category: any;
  categoryId: any;
  constructor(private categoryService: CategoryService) {}

  ngOnInit(): void {
    this.listCategory();
  }
  listCategory() {
    this.categoryService.listCategory().subscribe((data) => {
      this.category = data;
      console.log('category', this.category);
    });
  }
  getById() {
    this.categoryService.getById(this.categoryId).subscribe((data) => {
      this.category = data;
      console.log('funciona', this.category);
    });
  }
  //   getFocus() {

  //   document.getElementById('ob').focus();

  //     var ob = document.getElement[('ob')].value

  // }
}
