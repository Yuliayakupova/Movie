package com.accenture.moviecollection.controller;

import com.accenture.moviecollection.dto.Movie;
import com.accenture.moviecollection.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

@RestController
public class MovieDetailController {

    @Autowired
    MovieRepository movieRepository;

    @GetMapping("/movie/{id}")
    public Movie getMovieById(@PathVariable Integer id) throws SQLException {
        return movieRepository.getMovieById(id);
    }

    @PostMapping("/movie/{id}")
    public Movie setMovieById(
        @PathVariable Integer id,
        @RequestParam("name") String name,
        @RequestParam("description") String description,
        @RequestParam("rating") Integer rating
    ) throws SQLException {
        return movieRepository.setMovieById(id, name, description, rating);
    }

}
