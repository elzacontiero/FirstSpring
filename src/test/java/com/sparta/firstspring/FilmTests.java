package com.sparta.firstspring;

import com.sparta.firstspring.entities.Film;
import com.sparta.firstspring.repositories.FilmRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;


@Transactional
@SpringBootTest
public class FilmTests {

    @Autowired
    private FilmRepository repo;


    @Test
    @DisplayName("Test if there are 96 films under 60 minutes")
    public void testFilmDurationLessThanXMinutes() {
        List<Film> resultOfFilms = repo.findAllFilmsLessThanXMin(60);
        Assertions.assertEquals(96,resultOfFilms.size());
    }
    @Test
    @DisplayName("Test if there are films that contain title with the word Bird in it")
    public void testFilmsThatContainTitleWithWordBird(){
        List<Film> resultOfFilms = repo.findByTitleContaining("BIRD");
        Film film = resultOfFilms.get(0);
        System.out.println(film);
        Assertions.assertTrue(film.getTitle().contains("BIRD"));

    }

}
