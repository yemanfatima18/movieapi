package com.example.movieapi.service;

import com.example.movieapi.model.Movie;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MovieService {

    private final List<Movie> movieList = new ArrayList<>();

    public Movie addMovie(Movie movie) {
        movieList.add(movie);
        return movie;
    }

    public Movie getMovieById(Integer id) {
        return movieList.stream()
                .filter(movie -> movie.getId().equals(id))
                .findFirst()
                .orElse(null);
    }
}
