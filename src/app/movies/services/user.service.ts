import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

import { apiUrl } from 'src/environments/environment';

@Injectable({
  providedIn: 'root',
})
export class UserService {
  constructor(private http: HttpClient) {}

  listUser() {
    return this.http.get(`${apiUrl}/movies/user`);
  }
  createUser(userPost: any) {
    return this.http.post(`${apiUrl}/movies/register`, userPost);
  }
}
