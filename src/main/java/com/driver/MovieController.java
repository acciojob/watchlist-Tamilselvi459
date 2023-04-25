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
@PostMapping("/add-director")
    public ResponseEntity  addDirector(@RequestBody Director director){
       boolean ans = movs.addd(director);
       if(ans==true){
           return new ResponseEntity("director created" , HttpStatus.OK);
       }
       return new ResponseEntity("director already exist" , HttpStatus.valueOf(400));
}
@GetMapping("/get-movie-by-name/{name}")
    public ResponseEntity getMovieByName(@PathVariable String name){
       try{
           Movie movie = movs.getbyname(name);
           return new ResponseEntity(movie ,HttpStatus.OK );
       }catch(MovieNotFound ex){
           return new ResponseEntity(ex.getMessage() , HttpStatus.valueOf(500));

       }
}
@GetMapping("/get-director-by-name/{name}")
    public ResponseEntity getDirectorByName(@PathVariable String name){
    try{
        Director director = movs.getbynamedir(name);
        return new ResponseEntity("director found",HttpStatus.OK);
    }catch(DirectornamenotFound ex){
        return new ResponseEntity(ex.getMessage() , HttpStatus.valueOf(500));
    }
}
@DeleteMapping("/delete-director-by-name")
    public ResponseEntity deleteDirectorByName(@RequestParam String name){
    try{
        boolean flag = movs.deletedir(name);
        return new ResponseEntity("movie deleted successfully" , HttpStatus.ACCEPTED);
    }catch(DirectornamenotFound ex){
        return new ResponseEntity(ex.getMessage() , HttpStatus.valueOf(500));
    }
}
}
