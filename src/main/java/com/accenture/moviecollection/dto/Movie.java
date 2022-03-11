package com.accenture.moviecollection.dto;

public class Movie {

    //Unique movie id from database
    private int id;

    //Movie name
    private String name;

    //Movie description
    private String description;

    //Movie rating 1--10
    private int  rating;

    public Movie(int id, String name, String description, int rating) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.rating = rating;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getRating() {
        return rating;
    }
}
