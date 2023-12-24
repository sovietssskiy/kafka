package com.landin.consumer.controllers;

import com.landin.consumer.model.Film;
import com.landin.consumer.model.Review;
import com.landin.consumer.repo.FilmRepository;
import com.landin.consumer.repo.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/review")
public class ReviewController {
    public ReviewRepository reviewRepository;

    @Autowired
    public ReviewController(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }
    @GetMapping
    public List<Review> getFilms () {return reviewRepository.findAll();}
}
