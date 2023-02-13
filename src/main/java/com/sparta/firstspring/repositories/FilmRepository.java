package com.sparta.firstspring.repositories;

import com.sparta.firstspring.entities.Film;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FilmRepository extends JpaRepository<Film, Integer> {
    // query using JPQL to return all films with length less than X minutes
    @Query(value = "SELECT f FROM Film f WHERE length < :filmLength")
    List<Film> findAllFilmsLessThanXMin(int filmLength);

    // Query to get all films with certain keyword in it.
    List<Film> findByTitleContaining(String keyword);

}

