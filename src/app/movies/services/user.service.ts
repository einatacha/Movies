import { Injectable } from '@angular/core';
 import { HttpClient } from '@angular/common/http';
 import { Observable } from 'rxjs';


import { apiUrl } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class UserService {



  constructor(
    private http: HttpClient
    )
   {

   }

  listUser(){

    return this.http.get(`${apiUrl}/movies/user`);
  }
}
