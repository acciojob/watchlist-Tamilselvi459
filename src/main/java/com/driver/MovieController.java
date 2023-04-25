package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/movies")
public class MovieController {

@Autowired
    MovieService movs;

@PostMapping("/add-movie")
    public ResponseEntity addMovie(@RequestBody Movie movie){
    boolean ans = movs.add(movie);
    if(ans==true) {
      return new ResponseEntity<>("movie created" , HttpStatus.OK);
   }
   return new ResponseEntity("movie already exists" , HttpStatus.valueOf(400));
}
@PostMapping("/addDirector")
    public ResponseEntity adddir(@RequestBody Director director){
       boolean ans = movs.addd(director);
       if(ans==true){
           return new ResponseEntity("director created" , HttpStatus.OK);
       }
       return new ResponseEntity("director already exist" , HttpStatus.valueOf(400));
}
@GetMapping("/getMovieByName/{name}")
    public ResponseEntity getmovie(@PathVariable String name){
       try{
           Movie movie = movs.getbyname(name);
           return new ResponseEntity(movie ,HttpStatus.OK );
       }catch(MovieNotFound ex){
           return new ResponseEntity(ex , HttpStatus.valueOf(500));

       }
}
}
