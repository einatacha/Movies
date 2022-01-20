import { CategoryService } from './../services/category.service';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { MatDialog } from '@angular/material/dialog';
import { Observable, of } from 'rxjs';
import { catchError } from 'rxjs/operators';

import { MoviesService } from './../services/movies.service';
import { ActivatedRoute, Router } from '@angular/router';
import { ActiveDescendantKeyManager } from '@angular/cdk/a11y';
import { HttpParams } from '@angular/common/http';

@Component({
  selector: 'app-movies',
  templateUrl: './movies.component.html',
  styleUrls: ['./movies.component.scss'],
})
export class MoviesComponent implements OnInit {
  title = 'movies';

  // public category : any;
  public movies: any;
  public moviesId: any;
  public puutMovies: any;
  // public form: FormGroup =this.formBuilder.group({
  //   id: [null],
  //   active : true,
  //   title : [null],
  //   image: [null],
  //   categorys: [null],
  //   synopsis: [null],
  //   releaseDate: [null],
  //   duration: [null],

  // });

  constructor(
    private moviesService: MoviesService,
    private activatedRoute: ActivatedRoute // private formBuilder:FormBuilder, // private CategoryService: CategoryService,
  ) {}

  ngOnInit(): void {
    this.listMovies();
    const par = this.activatedRoute.snapshot.paramMap.get('parametro');
    console.log(par);
    this.getById();
    this.moviesId;
    // this.listCategory();
  }

  listMovies() {
    this.moviesService.listMovies().subscribe((data) => {
      this.movies = data;
      console.log('movies', this.movies);
    });
  }
  //  createMovies(){
  //    this.moviesService.createMovies(this.form.value).subscribe(data=>{
  //      console.log("salvou");
  //    });
  //  }
  //  listCategory(){
  //   this.CategoryService.listCategory().subscribe(data => {
  //     this.category = data;
  //     console.log("category", this.category);
  //   });
  // }

  getById() {
    this.moviesService.getById(this.moviesId).subscribe((data) => {
      this.moviesId = data;
      console.log('moviesId', this.moviesId);
    });
  }
  // putMovies() {
  //   this.moviesService.putMovies(this.puutMovies.value, this.moviesId).subscribe((data) => {
  //     this.puutMovies.value, this.moviesId = data;
  //     console.log('putMovies', this.putMovies);
  //   });
  // }
}
