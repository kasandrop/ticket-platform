package com.cinemamicroservice.model;

import lombok.Data;

@Data
public class Ticket {
    private String screening_id;
    private String seat_id;
    private long user_id;
}
