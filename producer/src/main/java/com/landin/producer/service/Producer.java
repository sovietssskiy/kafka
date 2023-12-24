package com.landin.producer.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.landin.producer.model.Film;
import com.landin.producer.model.Review;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class Producer {


    private String rewiewTopic = "t.film.review";
    private String filmTopic = "t.film.film";

    private final ObjectMapper objectMapper;
    private final KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    public Producer(KafkaTemplate<String, String> kafkaTemplate, ObjectMapper objectMapper) {
        this.kafkaTemplate = kafkaTemplate;
        this.objectMapper = objectMapper;
    }

    public String sendMessage(Review review) throws JsonProcessingException {
        String reviewAsMessage = objectMapper.writeValueAsString(review);
        kafkaTemplate.send(rewiewTopic, reviewAsMessage);

        log.info("review produced {}", reviewAsMessage);

        return "message sent";
    }
    public String sendMessageFilm(Film film) throws JsonProcessingException {
        String filmAsMessage = objectMapper.writeValueAsString(film);
        kafkaTemplate.send(filmTopic, filmAsMessage);

        log.info("film produced {}", filmAsMessage);

        return "message sent";
    }



}
