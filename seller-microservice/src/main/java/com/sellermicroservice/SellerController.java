package com.sellermicroservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class SellerController {

    @Autowired
    private SellerService sellerService;

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

