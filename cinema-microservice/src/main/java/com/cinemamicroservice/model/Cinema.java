package com.cinemamicroservice.model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Cinema {
    private String name;
    private String company_name;
    private String address;
    private String city;
    private String province;
    private String country;
    private String postcode;
    private LocalDateTime registered_date;
    private int screens;
}
