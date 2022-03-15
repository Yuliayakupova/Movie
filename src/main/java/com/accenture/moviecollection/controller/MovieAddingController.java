package com.accenture.moviecollection.controller;


import com.accenture.moviecollection.dto.Movie;
import com.accenture.moviecollection.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;

@RestController
public class MovieAddingController {

    @Autowired
    MovieRepository movieRepository;

    @PostMapping("/movie")
    public Movie createNewMovie(
            @RequestParam("name") String name,
            @RequestParam("description") String description,
            @RequestParam("rating") Integer rating
    ) throws SQLException {
        return movieRepository.createNewMovie(name, description, rating);
    }

}
