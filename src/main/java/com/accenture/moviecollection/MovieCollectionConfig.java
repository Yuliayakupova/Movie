package com.accenture.moviecollection;

import com.accenture.moviecollection.repository.MovieRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.sqlite.jdbc4.JDBC4Connection;

import java.sql.DriverManager;

@Configuration
public class MovieCollectionConfig {

    @Bean
    public MovieRepository getMovieRepository(){
        return new MovieRepository();
    }


    @Bean
    public JDBC4Connection getDatabaseConnection(){

        final String url = String.format("jdbc:sqlite:%s",
                "imdb.db");

        Class.forName("org.sqlite.JDBC");

        try(final JDBC4Connection connection = (JDBC4Connection)  DriverManager.getConnection(url)) {

            connection.setAutoCommit(true);

            return connection;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
