package com.landin.producer.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.landin.producer.model.Film;
import com.landin.producer.model.Review;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class FilmService {
    private final Producer producer;

    @Autowired
    public FilmService(Producer producer) {
        this.producer = producer;
    }

    public String createFilm(Film film) throws JsonProcessingException {
        return producer.sendMessageFilm(film);
    }
}
