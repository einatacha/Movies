import { Router, ActivatedRoute } from '@angular/router';
import { CategoryService } from './../services/category.service';
import { FormGroup, FormBuilder } from '@angular/forms';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-categorypost',
  templateUrl: './category.post.component.html',
  styleUrls: ['./category.post.component.scss'],
})
export class CategoryPostComponent implements OnInit {
  title = 'categorypost';

  public category: any;
  public categoryPost: any;
  categoryId: any;
  public form: FormGroup;
  //  = this.formBuilder.group({
  //   active: true,
  //   name: [null],
  //   language: [null],
  // });

  constructor(
    private categoryService: CategoryService,
    private formBuilder: FormBuilder,
    private router: Router,
    private route: ActivatedRoute
  ) {
    this.form = this.formBuilder.group({
      id: [null],
      active: true,
      name: [null],
      language: [null],
    });
  }

  ngOnInit(): void {
    this.categoryId = this.route.snapshot.params['id'];
    this.getById();
  }

  createCategory() {
    this.categoryService.createCategory(this.form.value).subscribe((data) => {
      alert('Categoria salva com sucesso');
      setTimeout(() => {
        this.router.navigate(['category']);
      }, 5000);
      console.log('salvou');
    });
  }
  getById() {
    this.categoryService.getById(this.categoryId).subscribe((data) => {
      this.category = data;
      this.form.patchValue(this.category);
      console.log('funciona', this.category);
    });
  }
  putCategory() {
    this.categoryService
      .putCategory(this.categoryId, this.form.value)
      .subscribe((data) => {
        alert('categoria atualizada com sucesso');
        setTimeout(() => {
          this.router.navigate(['category']);
        }, 5000);
        console.log('atualizou');
      });
  }

  deleteCategory() {
    this.categoryService
      .deleteCategory(this.categoryId, this.form.value)
      .subscribe((data) => {
        alert('Categoria deletada com sucesso');
        setTimeout(() => {
          this.router.navigate(['category']);
        }, 3000);
        console.log('deletado');
      });
  }

  compareFn(c1: any, c2: any): boolean {
    return c1 && c2 ? c1.id === c2.id : c1 === c2;
  }
}
