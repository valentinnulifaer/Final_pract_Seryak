package com.example.final_pract.service;

import com.example.final_pract.entity.MovieEntity;
import com.example.final_pract.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {

    @Autowired
    private MovieRepository movieRepository;

    @Override
    public List<MovieEntity> getAllMovies() {
        return movieRepository.findAll();
    }

    @Override
    public MovieEntity getMovieById(Long id) {
        return movieRepository.findById(id).orElse(null);
    }

    @Override
    public MovieEntity createMovie(MovieEntity movie) {
        return movieRepository.save(movie);
    }

    @Override
    public MovieEntity updateMovie(Long id, MovieEntity movie) {
        movie.setId(id);
        return movieRepository.save(movie);
    }

    @Override
    public void deleteMovie(Long id) {
        movieRepository.deleteById(id);
    }
}
