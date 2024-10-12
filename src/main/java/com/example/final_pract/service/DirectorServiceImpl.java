package com.example.final_pract.service;

import com.example.final_pract.entity.DirectorEntity;
import com.example.final_pract.repository.DirectorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DirectorServiceImpl implements DirectorService {

    @Autowired
    private DirectorRepository directorRepository;

    @Override
    public List<DirectorEntity> getAllDirectors() {
        return directorRepository.findAll();
    }

    @Override
    public DirectorEntity getDirectorById(Long id) {
        return directorRepository.findById(id).orElse(null);
    }

    @Override
    public DirectorEntity createDirector(DirectorEntity director) {
        return directorRepository.save(director);
    }

    @Override
    public DirectorEntity updateDirector(Long id, DirectorEntity director) {
        director.setId(id);
        return directorRepository.save(director);
    }

    @Override
    public void deleteDirector(Long id) {
        directorRepository.deleteById(id);
    }
}
