package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")

public class MovieController {

@Autowired
    MovieService movieservice;

@PostMapping("/add-movie")
    public ResponseEntity<String> addMovie(@RequestBody Movie movie){
     String ans = movieservice.addMovie(movie);
     return new ResponseEntity<>(ans , HttpStatus.CREATED);
}
@PostMapping("/add-director")
    public ResponseEntity<String> addDirector(@RequestBody Director director){
     String ans = movieservice.addDirector(director);
     return new ResponseEntity<>(ans, HttpStatus.CREATED);
}
@PutMapping("/add-movie-director-pair")
public ResponseEntity<String>addMovieDirectorPair(@RequestParam("moviename") String moviename ,@RequestParam("directorname") String directorname){
    String ans = movieservice.addMovieDirectorPair(moviename , directorname);
    return new ResponseEntity<>(ans,HttpStatus.CREATED);
}
@GetMapping("/get-movie-by-name/{name}")
    public ResponseEntity<Movie> getMovieByName(@PathVariable String name){
    Movie movie = movieservice. getMovieByName(name);
    return new ResponseEntity<>(movie , HttpStatus.FOUND);

}
@GetMapping("/get-director-by-name/{name}")
public ResponseEntity<Director> getDirectorByName(@PathVariable String name){
    Director director = movieservice.getDirectorByName(name);
    return new ResponseEntity<>(director , HttpStatus.FOUND);
}
@GetMapping("/get-movies-by-director-name/{director}")
public ResponseEntity<List<String>> getMoviesByDirectorName(@PathVariable String name){
    List<String> ans = movieservice.getMovieByDirectorName(name);
    return new ResponseEntity<>(ans,HttpStatus.OK);
}
@GetMapping("/get-all-movies")
public ResponseEntity<List<String>> findAllMovies(){
    List<String> ans = movieservice.findAllMovies();
    return new ResponseEntity<>(ans,HttpStatus.OK);
}
@DeleteMapping("/delete-director-by-name")
    public ResponseEntity<String> deleteDirectorByName(@RequestParam ("directorname") String name){
    String ans = movieservice.deleteDirectorByName(name);
    return new ResponseEntity<>(ans,HttpStatus.OK);
}
@DeleteMapping("/delete-all-directors")
    public ResponseEntity<String> deleteAllDirectors(){
   String ans = movieservice.deleteAllDirector();
   return new ResponseEntity<>(ans,HttpStatus.OK);
}

}
