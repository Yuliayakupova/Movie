package com.accenture.moviecollection.repository;

import com.accenture.moviecollection.dto.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.sqlite.jdbc4.JDBC4Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class MovieRepository {

    private final static String SELECT_MOVIE_BY_ID = "SQL for select all movies";
    private final static String UPDATE_MOVIE_BY_ID = "SQL for update moview";
    private final static String INSERT_MOVIE = "SQL for insert movie";

    @Autowired
    private JDBC4Connection database;

    public Movie getMovieById(Integer id) throws SQLException {

        final PreparedStatement statement = database.prepareStatement(SELECT_MOVIE_BY_ID);
        statement.setInt(1, id);

        final ResultSet rs = statement.executeQuery();

        if(rs.next() == false){
            return null;
        }

        return new Movie(
            rs.getInt("id"),
            rs.getString("name"),
            rs.getString("description"),
            rs.getInt("rating"));
    }


    public Movie setMovieById(Integer id, String name, String description, Integer rating) throws SQLException {

        final PreparedStatement statement = database.prepareStatement(UPDATE_MOVIE_BY_ID);

        return new Movie(id,name,description,rating);
    }

    public Movie createNewMovie(String name, String description, Integer rating) throws SQLException {

        final PreparedStatement statement = database.prepareStatement(INSERT_MOVIE);

        return new Movie(0, name, description, rating);
    }

    public static List<Movie> getAllMovies() {

        List<Movie> result = new ArrayList();

        result.add(new Movie(1, "name1", "des", 1));
        result.add(new Movie(2, "name1", "des", 5));
        result.add(new Movie(3, "name1", "des", 10));
        result.add(new Movie(4, "name1", "des", 3));
        result.add(new Movie(5, "name1", "des", 2));

        Collections.sort(result);
        return result;
    }
}
