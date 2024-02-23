package com.sellermicroservice;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;


@Entity
@Getter
@Setter
@Table(name = "Sellers")
public class Seller {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int sellerId;

    @Column(name = "UserID")
    private int userId;

    @Column(name = "BusinessName")
    private String businessName;

    @Column(name = "Email")
    private String email;




}

