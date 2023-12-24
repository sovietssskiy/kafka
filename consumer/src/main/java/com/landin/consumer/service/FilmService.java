package com.landin.consumer.service;

import com.landin.consumer.model.Film;
import com.landin.consumer.model.Review;
import com.landin.consumer.repo.FilmRepository;
import com.landin.consumer.repo.ReviewRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class FilmService {
    private final FilmRepository filmRepository;

    @Autowired
    public FilmService(FilmRepository filmRepository) {
        this.filmRepository = filmRepository;
    }

    public void persistFilm(Film film) {
        Film persistedFilm = filmRepository.save(film);
        log.info("film persisted {}", persistedFilm);
    }
}
