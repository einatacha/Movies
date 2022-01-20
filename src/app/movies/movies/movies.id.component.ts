import { ActivatedRoute } from '@angular/router';
import { Component, OnInit } from '@angular/core';

import { MoviesService } from '../services/movies.service';

@Component({
  selector: 'app-moviesId',
  templateUrl: './movies.id.component.html',
  styleUrls: ['./movies.id.component.scss'],
})
export class MoviesIdComponent implements OnInit {
  title = 'moviesId';

  public moviesId: any;

  constructor(
    private moviesService: MoviesService,
    private route: ActivatedRoute
  ) {}

  ngOnInit(): void {
    // this.getById();
    this.moviesId = this.route.snapshot.params['id'];
    this.getById();
  }

  getById() {
    this.moviesService.getById(this.moviesId).subscribe((data) => {
      this.moviesId = data;
      console.log('funciona', this.moviesId);
    });
  }
}
