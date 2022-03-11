package com.accenture.moviecollection.controller;


import com.accenture.moviecollection.dto.Movie;
import com.accenture.moviecollection.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MovieOverviewController {

    @Autowired
    MovieRepository movieRepository;

    @GetMapping("/movies")
    public List<Movie> getAllMovies() {

        return movieRepository.getAllMovies();
    }
}
