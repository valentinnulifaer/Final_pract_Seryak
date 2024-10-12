package com.example.final_pract.controller;

import com.example.final_pract.entity.GenreEntity;
import com.example.final_pract.service.GenreService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.BindingResult;
import java.util.List;

@Controller
@RequestMapping("/genres")
public class GenreController {

    @Autowired
    private GenreService genreService;

    @GetMapping
    public String getAllGenres(Model model) {
        List<GenreEntity> genres = genreService.getAllGenres();
        model.addAttribute("genres", genres);
        return "genreList";
    }

    @GetMapping("/add")
    public String showAddGenreForm(Model model) {
        model.addAttribute("genre", new GenreEntity());
        return "genreForm";
    }

    @PostMapping("/add")
    public String addGenre(@Valid @ModelAttribute("genre") GenreEntity genre, BindingResult result) {
        if (result.hasErrors()) {
            return "genreForm";
        }
        genreService.createGenre(genre);
        return "redirect:/genres";
    }

    @GetMapping("/edit/{id}")
    public String showEditGenreForm(@PathVariable("id") Long id, Model model) {
        GenreEntity genre = genreService.getGenreById(id);
        if (genre == null) {
            return "redirect:/genres";
        }
        model.addAttribute("genre", genre);
        return "genreForm";
    }

    @PostMapping("/update/{id}")
    public String updateGenre(@PathVariable("id") Long id, @Valid @ModelAttribute("genre") GenreEntity genre, BindingResult result) {
        if (result.hasErrors()) {
            return "genreForm";
        }
        genreService.updateGenre(id, genre);
        return "redirect:/genres";
    }

    @PostMapping("/delete/{id}")
    public String deleteGenre(@PathVariable("id") Long id) {
        genreService.deleteGenre(id);
        return "redirect:/genres";
    }
}
