import { MoviesIdComponent } from './movies/movies/movies.id.component';
// import { UserPostComponent } from './movies/user/user.post.component';
import { MoviesPostComponent } from './movies/movies/movies.post.component';
import { CategoryComponent } from './movies/category/category.component';
import { MoviesComponent } from './movies/movies/movies.component';
import { NgModule, Component } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { UserComponent } from './movies/user/user.component';

const routes: Routes = [
  {
    path: '',
    children: [
      { path: '', redirectTo: 'movies', pathMatch: 'prefix' },
      {
        path: 'movies',
        component: MoviesComponent,
        data: {
          reuse: true,
        },
      },
      {
        path: 'user',
        component: UserComponent,
      },
      {
        path: 'category',
        component: CategoryComponent,
      },
      {
        path: 'moviesRegister',
        component: MoviesPostComponent,
      },
      // {
      //   path: 'userRegister',
      //   component: UserPostComponent,
      // },
      {
        path: 'moviesId/:id',
        component: MoviesIdComponent,
      },
      // // {
      //   path: 'moviesRegister', Component :
      // }
    ],
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
