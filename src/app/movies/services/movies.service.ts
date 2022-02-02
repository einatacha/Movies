import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
// import { Movie } from '../model/movie';

import { apiUrl } from 'src/environments/environment';

@Injectable({
  providedIn: 'root',
})
export class MoviesService {
  constructor(private http: HttpClient) {}

  listMovies() {
    return this.http.get(`${apiUrl}/movies/list`);
  }
  createMovies(moviesPost: any) {
    return this.http.post(`${apiUrl}/movies/register`, moviesPost);
  }
  getById(moviesId: any) {
    return this.http.get(`${apiUrl}/movies/list/${moviesId}`);
  }
  putMovies(moviesId: any, movie: any) {
    return this.http.put(`${apiUrl}/movies/update/${moviesId}`, movie);
  }
  deleteMovie(moviesId: any, movie: any) {
    return this.http.delete(`${apiUrl}/movies/delete/${moviesId}`, movie);
  }
}
