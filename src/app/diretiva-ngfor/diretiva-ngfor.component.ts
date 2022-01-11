import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-diretiva-ngfor',
  templateUrl: './diretiva-ngfor.component.html',
  styleUrls: ['./diretiva-ngfor.component.css']
})
export class DiretivaNgforComponent implements OnInit {

  movies: string[] = [];

  constructor() { }

  ngOnInit() {
    for (let i=0; i<this.movies.length; i++){
      let curso = this.movies[i];
    }
  }

}
