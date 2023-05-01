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
        boolean flag = false;
        List<String> list = new ArrayList<>();
        for(Map.Entry<String,String>entry : moviedirectorpair.entrySet()){
            String a = entry.getValue();
            if(name.equals(a)){
                moviehm.remove(entry.getKey());
                flag = true;
                list.add(a);
            }
        }
        if(flag==true){
        for(String mname : list){
            moviedirectorpair.remove(mname); }
        }

    }

    public void  deleteAllDirector() {
        List<String> dirname = new ArrayList<>();
        List<String> mdir = new ArrayList<>();
        for(String name : directorhm.keySet()){

            dirname.add(name);

            for(Map.Entry<String,String> entry : moviedirectorpair.entrySet()){
                String a = entry.getValue();
                if(name.equals(a)) {
                    moviehm.remove(entry.getKey());
                    mdir.add(entry.getKey());
                    // moviedirectorpair.remove(entry.getKey());
                }
            }
        }
        for(String name : dirname) directorhm.remove(name);
        for(String name : mdir) moviedirectorpair.remove(name);

    }


}
