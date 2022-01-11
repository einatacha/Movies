import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { MatDialog } from '@angular/material/dialog';
import { Observable, of } from 'rxjs';
import { catchError } from 'rxjs/operators';

import { MoviesService } from './../services/movies.service';

@Component({
  selector: 'app-movies',
  templateUrl: './movies.component.html',
  styleUrls: ['./movies.component.scss']

})


export class MoviesComponent implements OnInit {
title = 'movies';

 public movies : any;
 public form: FormGroup =this.formBuilder.group({
  id: [null],
  title : [null],
  categorys: [null],
  synopsis: [null],
  releaseDate: [null],
  duration: [null],


});

  constructor(
    private moviesService: MoviesService,
    private formBuilder:FormBuilder
  ) {


  }



  ngOnInit(): void {
    this.listMovies();
    // this.createMovies();

  }
listMovies(){
  this.moviesService.listMovies().subscribe(data => {
    this.movies = data;
    console.log("movies", this.movies);
  });
}
 createMovies(){
   this.moviesService.createMovies(this.form).subscribe(data=>{
     console.log("salvou");
   });
 }



// createMovies(){
// this.moviesService.createMovies().subscribe(data=>{
//   this.movies= data;
//   console.log("movies", this.movies);
// });
// }
}
