import { CategoryComponent } from './movies/category/category.component';
import { MoviesComponent } from './movies/movies/movies.component';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { UserComponent } from './movies/user/user.component';

const routes: Routes = [


{
  path:'',  children: [
    { path: "", redirectTo: 'movies', pathMatch: 'prefix' },
    { path: "movies", component: MoviesComponent, data:
    {
      reuse: true
    }
  },
  {
    path: 'user', component : UserComponent
  },
    {

  path:'category',component : CategoryComponent
},


  ]
}
];


@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

