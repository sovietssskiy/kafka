package com.landin.consumer.model.dto;

import lombok.Data;
import lombok.Value;

@Data
@Value
public class ReviewDto {
    Integer id_film;
    Double rate;
    String message;
}
