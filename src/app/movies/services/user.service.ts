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
    return this.http.post(`${apiUrl}/movies/user/register`, userPost);
  }
  getById(userId: any) {
    return this.http.get(`${apiUrl}/movies/user/${userId}`);
  }
  putUser(userId: any, user: any) {
    return this.http.put(`${apiUrl}movies/user/update/${userId}`, user);
  }
  deleteUser(userId: any, user: any) {
    return this.http.delete(`${apiUrl}/movies/user/delete/${userId}`, user);
  }
}
