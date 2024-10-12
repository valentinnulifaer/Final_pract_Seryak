package com.example.final_pract.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import java.util.Set;

@Entity
@Table(name = "directors")
public class DirectorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Имя не может быть пустым")
    private String firstName;

    @NotBlank(message = "Фамилия не может быть пустой")
    private String lastName;

    @Column(length = 2000)
    private String bio;

    @OneToMany(mappedBy = "director")
    private Set<MovieEntity> movies;

    // Геттеры и сеттеры

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id= id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName= firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName= lastName;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio= bio;
    }

    public Set<MovieEntity> getMovies() {
        return movies;
    }

    public void setMovies(Set<MovieEntity> movies) {
        this.movies= movies;
    }
}
