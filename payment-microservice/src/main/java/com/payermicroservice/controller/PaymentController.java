package com.payermicroservice.controller;

import com.payermicroservice.model.Payment;
import com.payermicroservice.model.dao.PaymentDao;
import com.payermicroservice.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@Slf4j
@RequestMapping("/api/payment")
public class PaymentController {

    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    // Add payment method for user
    @PostMapping("/add")
    public ResponseEntity<PaymentDao> addPaymentMethod(@RequestBody Payment payment) {
        return ResponseEntity.ok().body(paymentService.addPaymentDetails(payment));
    }

    // Get payment by user id
    @GetMapping("/user")
    public ResponseEntity<PaymentDao> paymentDetails(@RequestParam() long user_id) {
        return ResponseEntity.ok().body(paymentService.getPaymentDetailsByUserId(user_id));
    }

}
