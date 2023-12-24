package com.landin.producer.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.landin.producer.model.Film;
import com.landin.producer.service.FilmService;
import com.landin.producer.service.ReviewService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/film")
public class FilmController {
    private final FilmService filmService;

    @Autowired
    public FilmController(FilmService filmService) {
        this.filmService = filmService;
    }

    private final RestTemplate restTemplate = new RestTemplate();

    @PostMapping
    public String createFilm(@RequestBody Film film) throws JsonProcessingException {
        log.info("create film request received");
        return filmService.createFilm(film);
    }
    @GetMapping
    public List getAllfilms()  {
        ResponseEntity<List> response = restTemplate
                .getForEntity("http://consumer:8081/film", List.class);
        return response.getBody();
    }
}
