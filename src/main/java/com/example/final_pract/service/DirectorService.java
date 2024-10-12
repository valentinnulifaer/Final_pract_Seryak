package com.example.final_pract.service;

import com.example.final_pract.entity.DirectorEntity;
import java.util.List;

public interface DirectorService {
    List<DirectorEntity> getAllDirectors();
    DirectorEntity getDirectorById(Long id);
    DirectorEntity createDirector(DirectorEntity director);
    DirectorEntity updateDirector(Long id, DirectorEntity director);
    void deleteDirector(Long id);
}
