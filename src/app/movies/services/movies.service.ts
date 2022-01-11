import { Injectable } from '@angular/core';
 import { HttpClient } from '@angular/common/http';
 import { Observable } from 'rxjs';
// import { Movie } from '../model/movie';

import { apiUrl } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class MoviesService {



  constructor(
    private http: HttpClient
    )
   {

   }

  listMovies(){
     return this.http.get(`${apiUrl}/movies/list`);

  }
  createMovies(movies: any){
    return this.http.post(`${apiUrl}/movies/register`, movies);

  }

  // post(url: string, body: any | null, options?: {
  //   headers?: HttpHeaders | {
  //       [header: string]: string | string[];
    };


// @PostMapping(value = "/register")
// public Movies createMovies(@RequestBody @Valid Movies movies) {
//     return moviesService.save(movies);
// }
