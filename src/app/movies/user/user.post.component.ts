// import { CategoryService } from './../services/category.service';
// import { Component, OnInit } from '@angular/core';
// import { FormBuilder, FormGroup } from '@angular/forms';
// import { MatDialog } from '@angular/material/dialog';
// import { Observable, of } from 'rxjs';
// import { catchError } from 'rxjs/operators';

// import { MoviesService } from './../services/movies.service';

// @Component({
//   selector: 'app-moviespost',
//   templateUrl: './movies.post.component.html',
//   styleUrls: ['./movies.post.component.scss'],
// })
// export class MoviesPostComponent implements OnInit {
//   title = 'moviespost';

//   public category: any;
//   public moviesPost: any;
//   public form: FormGroup = this.formBuilder.group({
//     id: [null],
//     active: true,
//     title: [null],
//     categorys: [null],
//     synopsis: [null],
//     releaseDate: [null],
//     duration: [null],
//   });

//   constructor(
//     private moviesService: MoviesService,
//     private formBuilder: FormBuilder,
//     private CategoryService: CategoryService
//   ) {}

//   ngOnInit(): void {
//     this.listCategory();
//   }

//   createMovies() {
//     this.moviesService.createMovies(this.form.value).subscribe((data) => {
//       console.log('salvou');
//     });
//   }
//   listCategory() {
//     this.CategoryService.listCategory().subscribe((data) => {
//       this.category = data;
//       console.log('category', this.category);
//     });
//   }
// }


import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { Observable, of } from 'rxjs';
import { catchError } from 'rxjs/operators';

import { UserService } from './../services/user.service';

@Component({
  selector: 'app-userpost',
  templateUrl: './user.post.component.html',
  styleUrls: ['./user.post.component.scss'],
})
export class UserPostComponent implements OnInit {
  title = 'userpost';

  public user: any;
  public userPost: any;
  public form: FormGroup = this.formBuilder.group({
    //     id: [null],
    //     active: true,
    //     title: [null],
    //     categorys: [null],
    //     synopsis: [null],
    //     releaseDate: [null],
    //     duration: [null],
      });


  constructor(private userService: UserService) {}
  //   onSelect(user){

  // }
  ngOnInit(): void {

  }


    createUser() {
          this.userService.createUser(this.form.value).subscribe((data) => {
            console.log('salvou');
          });
        }
  }
}
