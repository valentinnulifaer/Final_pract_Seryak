package com.example.final_pract.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "movies")
public class MovieEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Название фильма не может быть пустым")
    private String title;

    @Column(length = 5000)
    private String description;

    @PastOrPresent(message = "Дата выхода не может быть из будущего")
    private LocalDate releaseDate;

    @DecimalMin(value = "0.0", inclusive = true, message = "Рейтинг не может быть меньше 0")
    @DecimalMax(value = "10.0", inclusive = true, message = "Рейтинг не может быть больше 10")
    private Double rating;

    @ManyToOne
    @JoinColumn(name = "genre_id")
    private GenreEntity genre;

    @ManyToOne
    @JoinColumn(name = "director_id")
    private DirectorEntity director;

    @ManyToMany
    @JoinTable(
            name = "movie_actors",
            joinColumns = @JoinColumn(name = "movie_id"),
            inverseJoinColumns = @JoinColumn(name = "actor_id")
    )
    private Set<ActorEntity> actors = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id= id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title= title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description= description;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate= releaseDate;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating= rating;
    }

    public GenreEntity getGenre() {
        return genre;
    }

    public void setGenre(GenreEntity genre) {
        this.genre= genre;
    }

    public DirectorEntity getDirector() {
        return director;
    }

    public void setDirector(DirectorEntity director) {
        this.director= director;
    }

    public Set<ActorEntity> getActors() {
        return actors;
    }

    public void setActors(Set<ActorEntity> actors) {
        this.actors= actors;
    }
}
