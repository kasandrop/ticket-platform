package com.sellermicroservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

@RestController
public class SellerController {

    @Value("${spring.application.name}")
    private String serviceName;

    @Autowired
    private SellerService sellerService;

    @GetMapping("/")
    public String home() {
        return "Hello, " + serviceName;
    }

    @GetMapping("/api")
    public String api() {
        return "Hello, from api and " + serviceName;
    }

    @PostMapping("/registerSeller")
    public Seller registerSeller(@RequestBody Seller seller) {
        return sellerService.registerSeller(seller);
    }

    @GetMapping("/listTicket/{sellerId}")
    public List<Listing> listTicket(@PathVariable("sellerId") int sellerId) {
        return sellerService.listTicket(sellerId);
    }

    @PutMapping("/manageListing")
    public Listing manageListing(@RequestBody Listing listing) {
        return sellerService.manageListing(listing);
    }
}

