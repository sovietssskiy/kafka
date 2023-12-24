package com.landin.consumer.service;

import com.landin.consumer.model.Review;
import com.landin.consumer.repo.ReviewRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ReviewService {
    private final ReviewRepository reviewRepository;

    @Autowired
    public ReviewService(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    public void persistReview(Review review) {
        Review persistedReview = reviewRepository.save(review);
        log.info("review persisted {}", persistedReview);
    }
}
