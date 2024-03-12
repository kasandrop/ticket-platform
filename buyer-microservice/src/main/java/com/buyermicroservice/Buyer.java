package com.buyermicroservice;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

    @Entity
    @Table(name = "Buyers")
    @Getter
    @Setter
    public class Buyer {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int buyerID;

        @Column(name = "userID")
        private int userID;

    }




