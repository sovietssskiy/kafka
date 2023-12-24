package com.landin.consumer.controllers;

import com.landin.consumer.model.Film;
import com.landin.consumer.repo.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/film")
public class FilmController {
    public FilmRepository filmRepository;

    @Autowired
    public FilmController(FilmRepository filmRepository) {
        this.filmRepository = filmRepository;
    }
    @GetMapping
    public List<Film> getFilms () {return filmRepository.findAll();}

}
