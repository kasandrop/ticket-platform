package com.buyermicroservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class BuyerController {

    @Autowired
    private BuyerService buyerService;

    @GetMapping("/searchTickets")
    public List<String> searchTickets(@RequestParam String query) {
        //return buyerService.searchTickets(query);
        return List.of("Test");
    }

    @PostMapping("/purchaseTicket")
    public Order purchaseTicket(@RequestBody Order order) {
        return buyerService.purchaseTicket(order);
    }

    @GetMapping("/manageOrders/{buyerid}")
    public List<Order> manageOrders(@PathVariable int buyerid) {
        return buyerService.manageOrders(buyerid);
    }
}

