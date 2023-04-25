package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class MovieService {

    @Autowired
    MovieRepository movr;

    public boolean add(Movie movie){
    Optional<Movie> optmov = movr.getMoviebyname(movie.getName());
    if(optmov.isPresent()){
        return false;
    }
    return movr.addmovie(movie);
    }

    public boolean addd(Director director) {
        Optional<Director> optdir = movr.getMovieBydir(director.getName());
        if(optdir.isPresent()){
            return false;
        }
        return movr.adddirec(director);
    }
    public Movie getbyname(String name){
        Optional<Movie> op = movr.getMoviebyname(name);
        if(op.isEmpty()){
             throw new MovieNotFound(name);
        }
        return op.get();
    }
}
