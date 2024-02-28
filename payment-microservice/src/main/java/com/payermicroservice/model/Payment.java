package com.payermicroservice.model;

import lombok.Data;

@Data
public class Payment {
    private String payment_type;
    private String card_number;
    private String card_name;
    private String expiry_date;
    private String cvv;
    private long user_id;
}
