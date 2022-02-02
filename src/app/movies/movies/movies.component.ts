import { CategoryService } from './../services/category.service';
import { Component, OnInit } from '@angular/core';

import { MoviesService } from './../services/movies.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-movies',
  templateUrl: './movies.component.html',
  styleUrls: ['./movies.component.scss'],
})
export class MoviesComponent implements OnInit {
  title = 'movies';

  public movies: any;
  public moviesId: any;
  public puutMovies: any;

  constructor(
    private moviesService: MoviesService,
    private activatedRoute: ActivatedRoute
  ) {}

  ngOnInit(): void {
    this.listMovies();
    const par = this.activatedRoute.snapshot.paramMap.get('parametro');
    console.log(par);
    this.getById();
    this.moviesId;
  }

  listMovies() {
    this.moviesService.listMovies().subscribe((data) => {
      this.movies = data;
      console.log('movies', this.movies);
    });
  }

  getById() {
    this.moviesService.getById(this.moviesId).subscribe((data) => {
      this.moviesId = data;
      console.log('moviesId', this.moviesId);
    });
  }
}
