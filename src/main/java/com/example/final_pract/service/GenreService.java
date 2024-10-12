package com.example.final_pract.service;

import com.example.final_pract.entity.GenreEntity;
import java.util.List;

public interface GenreService {
    List<GenreEntity> getAllGenres();
    GenreEntity getGenreById(Long id);
    GenreEntity createGenre(GenreEntity genre);
    GenreEntity updateGenre(Long id, GenreEntity genre);
    void deleteGenre(Long id);
}
