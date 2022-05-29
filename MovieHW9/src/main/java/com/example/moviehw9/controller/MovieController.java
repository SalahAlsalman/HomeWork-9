package com.example.moviehw9.controller;

import com.example.moviehw9.model.Movie;
import com.example.moviehw9.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("api/v1/movie")
@RequiredArgsConstructor
public class MovieController {

    private final MovieService movieService;

    @GetMapping
    public ResponseEntity getMovies(){
        return ResponseEntity.status(200).body(movieService.getMovies());
    }

    @PostMapping
    public ResponseEntity addMovie(@RequestBody @Valid Movie movie, Errors errors) {
        if (errors.hasErrors()) {
            return ResponseEntity.status(400).body(errors);
        }
        movieService.addMovie(movie);
        return ResponseEntity.status(201).body("Movie Added!");
    }

    @PutMapping
    public ResponseEntity updateMovie(@RequestBody Movie movie, Errors  errors) {
        if (errors.hasErrors()) {
            return ResponseEntity.status(400).body(errors);
        }

        movieService.updateMovie(movie);
        return ResponseEntity.status(200).body("Movie Updated!");
    }

    @DeleteMapping("{id}")
    public ResponseEntity deleteMovie(@PathVariable String id) {
        movieService.deleteMovie(id);
        return ResponseEntity.status(200).body("Movie Deleted!");
    }
}
