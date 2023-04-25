package com.driver;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
@Repository

public class MovieRepository {

    Map<String ,Movie > data = new HashMap<>();
    Map<String , Director> hm = new HashMap<>();

    public boolean addmovie(Movie movie){
        data.put(movie.getName(),movie);
        return true;
    }

    public Optional<Movie> getMoviebyname(String name) {
        if(data.containsKey(name)){
            return Optional.of(data.get(name));
        }
        return Optional.empty();
    }
   public boolean adddirec(Director director){
        hm.put(director.getName() , director);
        return true;
   }
    public Optional<Director> getMovieBydir(String name) {
        if(hm.containsKey(name)){
            return Optional.of(hm.get(name));
        }
        return Optional.empty();
    }
}
