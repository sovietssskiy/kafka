package com.landin.consumer.model.dto;

import lombok.Data;
import lombok.Value;

@Data
@Value
public class FilmDto {
    String title;
    Integer year;
}
