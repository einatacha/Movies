import { ActivatedRoute } from '@angular/router';
import { CategoryService } from './../services/category.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-categoryId',
  templateUrl: './category.id.component.html',
  styleUrls: ['./category.id.component.scss'],
})
export class CategoryIdComponent implements OnInit {
  title = 'categoryId';

  public categoryId: any;

  constructor(
    private categoryService: CategoryService,
    private route: ActivatedRoute
  ) {}

  ngOnInit(): void {
    this.categoryId = this.route.snapshot.params['id'];
    this.getById();
  }

  getById() {
    this.categoryService.getById(this.categoryId).subscribe((data) => {
      this.categoryId = data;
      console.log('funciona', this.categoryId);
    });
  }
}
