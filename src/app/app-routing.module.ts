import { CategoryPostComponent } from './movies/category/category.post.component';
import { CategoryIdComponent } from './movies/category/category.id.component';
import { UserIdComponent } from './movies/user/user.id.component';
import { MoviesIdComponent } from './movies/movies/movies.id.component';
import { UserPostComponent } from './movies/user/user.post.component';
import { MoviesPostComponent } from './movies/movies/movies.post.component';
import { CategoryComponent } from './movies/category/category.component';
import { MoviesComponent } from './movies/movies/movies.component';
import { NgModule, Component } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { UserComponent } from './movies/user/user.component';
import { AcessibilidadeComponent } from './acessibilidade/acessibilidade.component';

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
        path: 'moviesRegister',
        component: MoviesPostComponent,
      },

      {
        path: 'moviesId/:id',
        component: MoviesIdComponent,
      },
      {
        path: 'update/:id',
        component: MoviesPostComponent,
      },
      {
        path: 'user',
        component: UserComponent,
      },
      {
        path: 'userId/:id',
        component: UserIdComponent,
      },
      {
        path: 'userRegister',
        component: UserPostComponent,
      },
      {
        path: 'userRegister/:id',
        component: UserPostComponent,
      },
      {
        path: 'categoryId/:id',
        component: CategoryIdComponent,
      },
      {
        path: 'categoryRegister/:id',
        component: CategoryPostComponent,
      },
      {
        path: 'category',
        component: CategoryComponent,
      },
      {
        path: 'acessibilidade',
        component: AcessibilidadeComponent,
      },
    ],
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
