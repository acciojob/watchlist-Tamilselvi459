package com.driver;

public class DirectornamenotFound extends RuntimeException {
    public DirectornamenotFound(String name) {
        super("director name not found for this name "+ name);
    }
}
