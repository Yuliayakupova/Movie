package com.accenture.moviecollection;

import com.accenture.moviecollection.dto.Movie;
import com.accenture.moviecollection.repository.MovieRepository;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@SpringBootTest
class MovieCollectionApplicationTests {

	@Autowired
	MovieRepository movieRepository;

	@Test
	void getMovie() throws SQLException {

		Movie result = movieRepository.getMovieById(1);
		Movie actual = new Movie(1, "new name1", "new name1", 10);

		Assert.assertEquals(result.getName(), actual.getName());
		Assert.assertEquals(result.getDescription(), actual.getDescription());
		Assert.assertEquals(result.getRating(), actual.getRating());

	}

	@Test
	public void getAllMovies_NO_NULL() throws SQLException {

		List<Movie> expected = movieRepository.getAllMovies(null);
		Assertions.assertNotNull(expected);
	}
}
