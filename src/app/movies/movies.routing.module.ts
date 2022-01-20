import { CategoryComponent } from './category/category.component';

import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { MoviesComponent } from './movies/movies.component';
import { UserComponent } from './user/user.component';

const routes: Routes = [
  // { path: '', component: MoviesComponent }
  // // {path:'', component: UserComponent},
  // // {path:'',component: CategoryComponent}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class MoviesRoutingModule {}
