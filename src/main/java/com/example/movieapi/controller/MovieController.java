package com.example.movieapi.controller;

import com.example.movieapi.model.Movie;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/movies")
public class MovieController {

    private List<Movie> movieList = new ArrayList<>();

    // Constructor - add some default movies
    public MovieController() {
        movieList.add(new Movie(1, "Inception", "Sci-Fi"));
        movieList.add(new Movie(2, "Avengers", "Action"));
    }

    // ===============================
    // ✅ Get all movies
    // ===============================
    @GetMapping
    public List<Movie> getAllMovies() {
        return movieList;
    }

    // ===============================
    // ✅ Get movie by ID
    // ===============================
    @GetMapping("/{id}")
    public Movie getMovieById(@PathVariable int id) {
        return movieList.stream()
                .filter(movie -> movie.getId() == id)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Movie not found with id: " + id));
    }

    // ===============================
    // ✅ Add new movie
    // ===============================
    @PostMapping
    public Movie addMovie(@RequestBody Movie movie) {
        movieList.add(movie);
        return movie;
    }

    // ===============================
    // ✅ Update movie
    // ===============================
    @PutMapping("/{id}")
    public Movie updateMovie(@PathVariable int id, @RequestBody Movie updatedMovie) {

        Movie movie = getMovieById(id);
        movie.setTitle(updatedMovie.getTitle());
        movie.setGenre(updatedMovie.getGenre());

        return movie;
    }

    // ===============================
    // ✅ Delete movie
    // ===============================
    @DeleteMapping("/{id}")
    public String deleteMovie(@PathVariable int id) {
        Movie movie = getMovieById(id);
        movieList.remove(movie);
        return "Movie deleted successfully!";
    }
}
