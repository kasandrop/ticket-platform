package com.cinemamicroservice.model;

import lombok.Data;

@Data
public class Seat {
    private int screen_number;
    private char row;
    private int seat_number;
    private String cinema_id;
}
