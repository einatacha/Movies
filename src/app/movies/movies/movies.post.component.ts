import { CategoryService } from './../services/category.service';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';

import { MoviesService } from './../services/movies.service';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-moviespost',
  templateUrl: './movies.post.component.html',
  styleUrls: ['./movies.post.component.scss'],
})
export class MoviesPostComponent implements OnInit {
  title = 'moviespost';

  public category: any;
  public moviesPost: any;
  moviesId: any;
  movie: any;
  public form: FormGroup;
  constructor(
    private moviesService: MoviesService,
    private formBuilder: FormBuilder,
    private CategoryService: CategoryService,
    private router: Router,
    private route: ActivatedRoute
  ) {
    this.form = this.formBuilder.group({
      id: [null],
      title: [null],
      active: true,
      image: [null],
      category: [null],
      synopsis: [null],
      releaseDate: [null],
      duration: [null],
    });
  }

  ngOnInit(): void {
    this.moviesId = this.route.snapshot.params['id'];
    this.getById();
    this.listCategory();
  }

  createMovies() {
    this.moviesService.createMovies(this.form.value).subscribe((data) => {
      alert('Filme salvo com sucesso');
      setTimeout(() => {
        this.router.navigate(['movies']);
      }, 5000);
      console.log('salvou');
    });
  }

  getById() {
    this.moviesService.getById(this.moviesId).subscribe((data) => {
      this.movie = data;
      this.form.patchValue(this.movie);
      console.log('funciona', this.movie);
    });
  }

  putMovies() {
    this.moviesService
      .putMovies(this.moviesId, this.form.value)
      .subscribe((data) => {
        alert('Filme atualizado com sucesso');
        setTimeout(() => {
          this.router.navigate(['movies']);
        }, 5000);
        console.log('atualizou');
      });
  }

  deleteMovie() {
    this.moviesService
      .deleteMovie(this.moviesId, this.form.value)
      .subscribe((data) => {
        alert('Filme deletado com sucesso');
        setTimeout(() => {
          this.router.navigate(['movies']);
        }, 3000);
        console.log('deletado');
      });
  }
  listCategory() {
    this.CategoryService.listCategory().subscribe((data) => {
      this.category = data;
      console.log('category', this.category);
    });
  }
  compareFn(c1: any, c2: any): boolean {
    return c1 && c2 ? c1.id === c2.id : c1 === c2;
  }
}
