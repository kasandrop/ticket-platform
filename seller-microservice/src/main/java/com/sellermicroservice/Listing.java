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
@Table(name = "Listings")
public class Listing {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int listingId;

    @Column(name = "SellerID")
    private int sellerId;

    @Column(name = "TicketID")
    private int ticketId;

    @Column(name = "Price")
    private double price;

    @Column(name = "Quantity")
    private int quantity;
    }