package com.landin.producer.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.landin.producer.model.Film;
import com.landin.producer.model.Review;
import com.landin.producer.service.ReviewService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/review")
public class ReviewController {
    private final ReviewService reviewService;
    private final RestTemplate restTemplate = new RestTemplate();

    @Autowired
    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @PostMapping
    public String createReview(@RequestBody Review review) throws JsonProcessingException {
        log.info("create review request received");
        return reviewService.createReview(review);
    }
    @GetMapping
    public List getAllfilms()  {
        ResponseEntity<List> response = restTemplate
                .getForEntity("http://consumer:8081/review", List.class);
        return response.getBody();
    }
}
