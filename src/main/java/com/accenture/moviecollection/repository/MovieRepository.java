package com.accenture.moviecollection.repository;

import com.accenture.moviecollection.dto.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.sqlite.jdbc4.JDBC4Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class MovieRepository {

    private final static String SELECT_MOVIE_ALL = "SELECT movie_id, movie_name, movie_description, movie_rating FROM movie";
    private final static String SELECT_MOVIE_BY_ID = "SELECT movie_id, movie_name, movie_description, movie_rating FROM movie WHERE movie_id = ?";
    private final static String UPDATE_MOVIE_BY_ID = "UPDATE movie SET movie_name = ?, movie_description = ?, movie_rating = ? WHERE movie_id=?;";
    private final static String INSERT_MOVIE = "INSERT INTO movie (movie_name, movie_description, movie_rating) VALUES (?, ?, ?) RETURNING movie_id;";

    @Autowired
    private JDBC4Connection database;

    public Movie getMovieById(Integer id) throws SQLException {

        try(final PreparedStatement statement = database.prepareStatement(SELECT_MOVIE_BY_ID)) {
            statement.setInt(1, id);

            final ResultSet rs = statement.executeQuery();

            if (rs.next() == false) {
                return null;
            }

            return new Movie(
                    rs.getInt("movie_id"),
                    rs.getString("movie_name"),
                    rs.getString("movie_description"),
                    rs.getInt("movie_rating"));
        }
    }


    public Movie setMovieById(Integer id, String name, String description, Integer rating) throws SQLException {

        try(final PreparedStatement statement = database.prepareStatement(UPDATE_MOVIE_BY_ID)) {

            statement.setString(1, name);
            statement.setString(2, name);
            statement.setInt(3, rating);
            statement.setInt(4, id);

            statement.execute();

            return new Movie(id, name, description, rating);
        }
    }

    public Movie createNewMovie(String name, String description, Integer rating) throws SQLException {

        try(final PreparedStatement statement = database.prepareStatement(INSERT_MOVIE)) {
            statement.setString(1, name);
            statement.setString(2, name);
            statement.setInt(3, rating);

            final ResultSet rs = statement.executeQuery();

            if (rs.next() == false) {
                return null;
            }

            return new Movie(
                    rs.getInt("movie_id"),
                    name,
                    description,
                    rating);
        }
    }

    public List<Movie> getAllMovies(String orderBy) throws SQLException {
        final List<Movie> result = new ArrayList();

        final StringBuilder query = new StringBuilder();
        query.append(SELECT_MOVIE_ALL);

        if(orderBy != null && (orderBy.equals("movie_name") || orderBy.equals("movie_description") || orderBy.equals("movie_rating"))){
            query.append(" ORDER BY ").append(orderBy);
        }

        try(final PreparedStatement statement = database.prepareStatement(query.toString())) {
            final ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                result.add(new Movie(
                        rs.getInt("movie_id"),
                        rs.getString("movie_name"),
                        rs.getString("movie_description"),
                        rs.getInt("movie_rating")));
            }

            return result;
        }
    }
}
