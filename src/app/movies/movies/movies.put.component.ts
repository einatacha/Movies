import { CategoryService } from './../services/category.service';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';

import { MoviesService } from './../services/movies.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-moviespost',
  templateUrl: './movies.put.component.html',
  styleUrls: ['./movies.put.component.scss'],
})
export class MoviesPutComponent implements OnInit {
  title = 'moviesput';

  public category: any;
  public moviesPost: any;
  public form: FormGroup = this.formBuilder.group({});

  constructor(
    private moviesService: MoviesService,
    private formBuilder: FormBuilder,
    private router: Router,
    private route: ActivatedRoute
  ) {}

  ngOnInit(): void {}

  createMovies() {
    this.moviesService.createMovies(this.form.value).subscribe((data) => {
      alert('Filme salvo com sucesso');
      setTimeout(() => {
        this.router.navigate(['movies']);
      }, 5000);
      console.log('salvou');
    });
  }
}
