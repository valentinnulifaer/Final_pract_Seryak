package com.example.final_pract.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import java.util.Set;

@Entity
@Table(name = "genres")
public class GenreEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Название жанра не может быть пустым")
    private String name;

    @OneToMany(mappedBy = "genre")
    private Set<MovieEntity> movies;

    // Геттеры и сеттеры

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id= id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name= name;
    }

    public Set<MovieEntity> getMovies() {
        return movies;
    }

    public void setMovies(Set<MovieEntity> movies) {
        this.movies= movies;
    }
}