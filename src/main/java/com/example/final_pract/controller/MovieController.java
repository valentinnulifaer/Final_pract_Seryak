package com.example.final_pract.controller;

import com.example.final_pract.entity.MovieEntity;
import com.example.final_pract.entity.GenreEntity;
import com.example.final_pract.entity.DirectorEntity;
import com.example.final_pract.entity.ActorEntity;
import com.example.final_pract.service.MovieService;
import com.example.final_pract.service.GenreService;
import com.example.final_pract.service.DirectorService;
import com.example.final_pract.service.ActorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.BindingResult;

import java.util.HashSet;
import java.util.List;

@Controller
@RequestMapping("/movies")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @Autowired
    private GenreService genreService;

    @Autowired
    private DirectorService directorService;

    @Autowired
    private ActorService actorService;

    @GetMapping
    public String getAllMovies(Model model) {
        List<MovieEntity> movies = movieService.getAllMovies();
        model.addAttribute("movies", movies);
        return "movieList";
    }

    @GetMapping("/add")
    public String showAddMovieForm(Model model) {
        MovieEntity movie = new MovieEntity();
        movie.setActors(new HashSet<>());
        model.addAttribute("movie", movie);
        model.addAttribute("genres", genreService.getAllGenres());
        model.addAttribute("directors", directorService.getAllDirectors());
        model.addAttribute("actors", actorService.getAllActors());
        return "movieForm";
    }

    @PostMapping("/add")
    public String addMovie(@Valid @ModelAttribute("movie") MovieEntity movie, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("genres", genreService.getAllGenres());
            model.addAttribute("directors", directorService.getAllDirectors());
            model.addAttribute("actors", actorService.getAllActors());
            return "movieForm";
        }
        movieService.createMovie(movie);
        return "redirect:/movies";
    }

    @GetMapping("/edit/{id}")
    public String showEditMovieForm(@PathVariable("id") Long id, Model model) {
        MovieEntity movie = movieService.getMovieById(id);
        if (movie == null) {
            return "redirect:/movies";
        }
        model.addAttribute("movie", movie);
        model.addAttribute("genres", genreService.getAllGenres());
        model.addAttribute("directors", directorService.getAllDirectors());
        model.addAttribute("actors", actorService.getAllActors());
        return "movieForm";
    }

    @PostMapping("/update/{id}")
    public String updateMovie(@PathVariable("id") Long id, @Valid @ModelAttribute("movie") MovieEntity movie, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("genres", genreService.getAllGenres());
            model.addAttribute("directors", directorService.getAllDirectors());
            model.addAttribute("actors", actorService.getAllActors());
            return "movieForm";
        }
        movieService.updateMovie(id, movie);
        return "redirect:/movies";
    }

    @PostMapping("/delete/{id}")
    public String deleteMovie(@PathVariable("id") Long id) {
        movieService.deleteMovie(id);
        return "redirect:/movies";
    }
}
