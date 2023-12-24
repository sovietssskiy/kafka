package com.landin.consumer.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    Integer id_film;
    Double rate;
    String message;

    public Review() {
    }

    public Review(Long id, Integer id_film, Double rate, String message) {
        this.id = id;
        this.id_film = id_film;
        this.rate = rate;
        this.message = message;
    }

    public Long getId() {
        return id;
    }

    public Integer getId_film() {
        return id_film;
    }

    public Double getRate() {
        return rate;
    }

    public String getMessage() {
        return message;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setId_film(Integer id_film) {
        this.id_film = id_film;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
