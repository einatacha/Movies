import { MoviesIdComponent } from './movies/movies/movies.id.component';
// import { UserPostComponent } from './movies/user/user.post.component';
import { MoviesPostComponent } from './movies/movies/movies.post.component';
import { CategoryComponent } from './movies/category/category.component';
import { HttpClient, HttpClientModule } from '@angular/common/http';

import { MoviesComponent } from './movies/movies/movies.component';
import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { MatToolbarModule } from '@angular/material/toolbar';
import { UserComponent } from './movies/user/user.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
@NgModule({
  declarations: [
    AppComponent,
    MoviesComponent,
    UserComponent,
    CategoryComponent,
    MoviesPostComponent,
    MoviesIdComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    MatToolbarModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule,
  ],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}
