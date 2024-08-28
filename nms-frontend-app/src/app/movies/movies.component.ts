import { Component, OnInit } from '@angular/core';
import { Movies } from '../movies';
import { MoviesService } from '../movies.service';
import { FormControl, FormGroup } from '@angular/forms';

@Component({
  selector: 'app-movies',
  templateUrl: './movies.component.html',
  styleUrls: ['./movies.component.css']
})
export class MoviesComponent implements OnInit{
  moviesRef = new FormGroup({
    mid:new FormControl(),
    mname:new FormControl(),
    language:new FormControl(),
    price:new FormControl(),
    qty:new FormControl(),
    date:new FormControl()
  })
  result:string = "";
  movies:Array<Movies>=[];
  constructor(public ms:MoviesService){}  // DI

  ngOnInit(): void {
    this.retrieveMoviesInfo();
  }
retrieveMoviesInfo() : void {
  this.ms.loadAllMoviesInfo().subscribe({
    next:(result:any)=> {
      this.movies=result;
    },
    error:(error:any)=> {
      console.log(error)
    },
    complete:()=> {
      console.log("Movie details loaded")
    }
  })

}
addMovie(): void {
  let movie = this.moviesRef.value;

  this.ms.storeMovie(Movies).subscribe({
    next:(result)=> {
      this.result=result;
    },

    error:(error)=> {
      console.log(error)
      this.result=error.message
    },

    complete:()=> {
      this.retrieveMoviesInfo();
    }
})


  this.moviesRef.reset();
}

}
