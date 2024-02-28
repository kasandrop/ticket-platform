package com.cinemamicroservice.model;

import lombok.Data;

@Data
public class Screening {
    private double price;
    private String screening_date;
    private int screen_number;
    private String cinema_id;
    private int movie_id;
}
