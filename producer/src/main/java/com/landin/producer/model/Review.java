package com.landin.producer.model;

import lombok.Data;
import lombok.Value;

@Data
@Value
public class Review {
    Integer id_film;
    Double rate;
    String message;
}
