package com.moviemicroservice.controller;

import com.moviemicroservice.model.dao.PaymentDao;
import com.moviemicroservice.model.dao.TicketDao;
import com.moviemicroservice.model.dao.UserDao;
import com.moviemicroservice.service.CinemaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@Slf4j
@RequestMapping("/user")
public class UserController {

    private final CinemaService cinemaService;

    public UserController(CinemaService cinemaService) {
        this.cinemaService = cinemaService;
    }


    @PostMapping("/register")
    ResponseEntity<UserDao> register(
            @RequestParam() String username,
            @RequestParam() String password,
            @RequestParam() String email,
            @RequestParam() String firstName,
            @RequestParam() String lastName,
            @RequestParam() String address,
            @RequestParam() String city,
            @RequestParam() String province,
            @RequestParam() String country,
            @RequestParam() String postcode

    ) {
        return ResponseEntity.ok().body(cinemaService.registerUser(new UserDao(username, password, email, firstName, lastName, address, city, province, country, postcode)));
    }

    // Returns user profile by username and password
    @GetMapping("/login")
    ResponseEntity<UserDao> userDetails(
            @RequestParam() String username,
            @RequestParam() String password
    ) {
        return ResponseEntity.ok().body(cinemaService.getUser(username, password));
    }

    // Returns user profile by id
    @GetMapping("")
    ResponseEntity<UserDao> userDetails(
            @RequestParam() String user_id
    ) {
        return ResponseEntity.ok().body(cinemaService.getUserById(user_id));
    }

    // Add payment
    @PostMapping("/payment/add")
    public ResponseEntity<PaymentDao> addScreening(
            @RequestParam() String payment_type,
            @RequestParam() String card_number,
            @RequestParam() String card_name,
            @RequestParam() String expiry_date,
            @RequestParam() String cvv,
            @RequestParam() String user_id) {
        return ResponseEntity.ok().body(cinemaService.addPaymentDetails(new PaymentDao(payment_type, card_number, card_name, LocalDate.parse(expiry_date), cvv, cinemaService.getUserById(user_id))));
    }

    // Returns users payment details
    @GetMapping("/payment")
    public ResponseEntity<PaymentDao> paymentDetails(@RequestParam() String user_id) {
        return ResponseEntity.ok().body(cinemaService.getPaymentDetailsByUserId(user_id));
    }

    // Returns list of users tickets
    @GetMapping("/tickets")
    public ResponseEntity<List<TicketDao>> userTickets(@RequestParam() String user_id) {
        return ResponseEntity.ok().body(cinemaService.getUserTickets(user_id));
    }

}
