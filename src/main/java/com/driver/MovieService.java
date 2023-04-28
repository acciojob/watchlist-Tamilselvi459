package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class MovieService {

    @Autowired
    MovieRepository movierepository;


    public void addMovie(Movie movie) {
         movierepository.addMovie(movie);

    }

    public void addDirector(Director director) {
        movierepository.addDirector(director);
    }

    public void addMovieDirectorPair(String moviename, String directorname) {
      movierepository.addMovieDirectorPair(moviename,directorname);

    }

    public Movie getMovieByName(String name) {
        return movierepository.getMovieByName(name);
    }

    public Director getDirectorByName(String name) {
        return movierepository.getDirectorByName(name);
    }

    public List<String> getMovieByDirectorName(String name) {
        return movierepository.getMovieByDirectorName(name);
    }

    public List<String> findAllMovies() {
        return movierepository.findAllMovies();
    }

    public void deleteDirectorByName(String name) {
         movierepository.deleteDirectorByName(name);
    }

    public void deleteAllDirector() {
         movierepository.deleteAllDirector();
    }
}
