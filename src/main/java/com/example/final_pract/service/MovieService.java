package com.example.final_pract.service;

import com.example.final_pract.entity.MovieEntity;
import java.util.List;

public interface MovieService {
    List<MovieEntity> getAllMovies();
    MovieEntity getMovieById(Long id);
    MovieEntity createMovie(MovieEntity movie);
    MovieEntity updateMovie(Long id, MovieEntity movie);
    void deleteMovie(Long id);
}
