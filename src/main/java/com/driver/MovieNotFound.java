package com.driver;

public class MovieNotFound extends RuntimeException {
    public MovieNotFound(String name) {
        super("book not found with this "+ name);
    }
}
