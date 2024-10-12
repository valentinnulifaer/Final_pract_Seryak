package com.example.final_pract.service;

import com.example.final_pract.entity.GenreEntity;
import com.example.final_pract.repository.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class GenreServiceImpl implements GenreService {

    @Autowired
    private GenreRepository genreRepository;

    @Override
    public List<GenreEntity> getAllGenres() {
        return genreRepository.findAll();
    }

    @Override
    public GenreEntity getGenreById(Long id) {
        return genreRepository.findById(id).orElse(null);
    }

    @Override
    public GenreEntity createGenre(GenreEntity genre) {
        return genreRepository.save(genre);
    }

    @Override
    public GenreEntity updateGenre(Long id, GenreEntity genre) {
        genre.setId(id);
        return genreRepository.save(genre);
    }

    @Override
    public void deleteGenre(Long id) {
        genreRepository.deleteById(id);
    }
}
