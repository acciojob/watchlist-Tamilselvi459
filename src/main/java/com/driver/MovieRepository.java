package com.driver;

import org.springframework.stereotype.Repository;

import java.util.*;

@Repository

public class MovieRepository {

    HashMap<String ,Movie > moviehm = new HashMap<>();
    HashMap<String , Director> directorhm = new HashMap<>();
    HashMap<String,String> moviedirectorpair = new HashMap<>();

    public void addMovie(Movie movie) {

        moviehm.put(movie.getName(),movie);
    }


    public void addDirector(Director director) {

        directorhm.put(director.getName(),director);
    }

    public void addMovieDirectorPair(String moviename, String directorname) {
        moviedirectorpair.put(moviename,directorname);
    }

    public Movie getMovieByName(String name) {
       Movie movie =  moviehm.get(name);
       return movie;
    }

    public Director getDirectorByName(String name) {
        Director director  = directorhm.get(name);
        return director;
    }

    public List<String> getMovieByDirectorName(String name) {
        List<String> ans = new ArrayList<>();
      for(Map.Entry<String, String> entry : moviedirectorpair.entrySet()){
          String a = entry.getValue();
         if(name.equals(a)) ans.add(entry.getKey());
      }
      return ans;
    }

    public List<String> findAllMovies() {
        List<String> ans = new ArrayList<>();
        for(Map.Entry<String,Movie> entry : moviehm.entrySet()){
            ans.add(entry.getKey());
        }
        return ans;
    }

    public void  deleteDirectorByName(String name) {
        directorhm.remove(name);
        for(Map.Entry<String,String>entry : moviedirectorpair.entrySet()){
            String a = entry.getValue();
            if(name.equals(a)){
                moviehm.remove(entry.getKey());
                moviedirectorpair.remove(entry.getKey());
            }
        }

    }

    public void  deleteAllDirector() {
        for(String name : directorhm.keySet()){

            directorhm.remove(name);

            for(Map.Entry<String,String> entry : moviedirectorpair.entrySet()){
                String a = entry.getValue();
                if(name.equals(a)) {
                    moviehm.remove(entry.getKey());
                    moviedirectorpair.remove(entry.getKey());
                }
            }
        }

    }


}
