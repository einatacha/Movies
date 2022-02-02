import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

import { apiUrl } from 'src/environments/environment';

@Injectable({
  providedIn: 'root',
})
export class CategoryService {
  constructor(private http: HttpClient) {}

  listCategory() {
    return this.http.get(`${apiUrl}/movies/category`);
  }
  createCategory(categoryPost: any) {
    return this.http.post(`${apiUrl}/movies/category/register`, categoryPost);
  }
  getById(categoryId: any) {
    return this.http.get(`${apiUrl}/movies/category/${categoryId}`);
  }

  putCategory(categoryId: any, category: any) {
    return this.http.put(
      `${apiUrl}/movies/category/update/${categoryId}`,
      category
    );
  }
  deleteCategory(categoryId: any, category: any) {
    return this.http.delete(
      `${apiUrl}/movies/category/delete/${categoryId}`,
      category
    );
  }
}
