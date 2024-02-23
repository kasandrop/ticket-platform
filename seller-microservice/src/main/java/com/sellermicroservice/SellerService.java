package com.sellermicroservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SellerService {

    @Autowired
    private SellerRepository sellerRepository;

    @Autowired
    private ListingRepository listingRepository;

    public Seller registerSeller(Seller seller) {
        // Implement your registration logic here
        return sellerRepository.save(seller);
    }

    public List<Listing> listTicket(int sellerId) {
        // Implement your ticket listing logic here
        return listingRepository.findBySellerId(sellerId);
    }

    public Listing manageListing(Listing listing) {
        // Implement your listing management logic here
        return listingRepository.save(listing);
    }
}
