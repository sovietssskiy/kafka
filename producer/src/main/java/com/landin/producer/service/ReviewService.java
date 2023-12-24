package com.landin.producer.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.landin.producer.model.Review;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ReviewService {
    private final Producer producer;

    @Autowired
    public ReviewService(Producer producer) {
        this.producer = producer;
    }

    public String createReview(Review review) throws JsonProcessingException {
        return producer.sendMessage(review);
    }
}
