package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class MovieService {

    @Autowired
    MovieRepository movierepository;


    public String addMovie(Movie movie) {
         movierepository.addMovie(movie);
         return "Movie added  successfully";
    }

    public String addDirector(Director director) {
        movierepository.addDirector(director);
        return "Director added successfully";
    }

    public String addMovieDirectorPair(String moviename, String directorname) {
      movierepository.addMovieDirectorPair(moviename,directorname);
      return "Pair connected successfully";
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

    public String deleteDirectorByName(String name) {
        return movierepository.deleteDirectorByName(name);
    }

    public String deleteAllDirector() {
        return movierepository.deleteAllDirector();
    }
}
