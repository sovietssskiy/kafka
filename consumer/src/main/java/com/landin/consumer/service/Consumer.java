package com.landin.consumer.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.landin.consumer.model.Film;
import com.landin.consumer.model.Review;
import com.landin.consumer.model.dto.FilmDto;
import com.landin.consumer.model.dto.ReviewDto;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class Consumer {
    private static final String filmTopic = "t.film.film";
    private static final String reviewTopic = "t.film.review";


    private final ObjectMapper objectMapper;
    private final ModelMapper modelMapper;
    private final ReviewService reviewService;
    private final FilmService filmService;


    @Autowired
    public Consumer(ObjectMapper objectMapper, ModelMapper modelMapper, ReviewService reviewService, FilmService filmService) {
        this.objectMapper = objectMapper;
        this.modelMapper = modelMapper;
        this.reviewService = reviewService;
        this.filmService = filmService;
    }

    @KafkaListener(topics = filmTopic)
    public void consumeMessage(String message) throws JsonProcessingException {

        log.info("message consumed {}", message);
        FilmDto filmDto = objectMapper.readValue(message, FilmDto.class);
        Film film = modelMapper.map(filmDto, Film.class);
        filmService.persistFilm(film);
    }
    @KafkaListener(topics = reviewTopic, groupId = "2")
    public void consumeMessageReview(String message) throws JsonProcessingException {
        log.info("message consumed {}", message);

        ReviewDto reviewDto = objectMapper.readValue(message, ReviewDto.class);
        Review review = modelMapper.map(reviewDto, Review.class);
        reviewService.persistReview(review);
    }
}
