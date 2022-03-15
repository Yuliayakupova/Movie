package com.accenture.moviecollection;

import com.accenture.moviecollection.dto.Movie;
import com.accenture.moviecollection.repository.MovieRepository;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@SpringBootTest
class MovieCollectionApplicationTests {


	@Test
	void getAllMovies() {

		List<Movie> result = new ArrayList();

		result.add(new Movie(1, "name1", "des", 1));
		result.add(new Movie(2, "name1", "des", 5));
		result.add(new Movie(3, "name1", "des", 10));
		result.add(new Movie(4, "name1", "des", 3));
		result.add(new Movie(5, "name1", "des", 2));



		List<Movie> actual = MovieRepository.getAllMovies();

		Collections.sort(result);
		Collections.sort(actual);
		Assert.assertEquals(result, actual);

	}

	@Test
	public void getAllMovies_NO_NULL() {

		List<Movie> expected = MovieRepository.getAllMovies();
		Assertions.assertNotNull(expected);
	}
}
