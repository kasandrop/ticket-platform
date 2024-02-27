package com.payermicroservice.controller;

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

    @PostMapping("/add")
    public ResponseEntity<PaymentDao> addPaymentMethod(
            @RequestParam() String payment_type,
            @RequestParam() String card_number,
            @RequestParam() String card_name,
            @RequestParam() String expiry_date,
            @RequestParam() String cvv,
            @RequestParam() long user_id) {
        return ResponseEntity.ok().body(paymentService.addPaymentDetails(new PaymentDao(payment_type, card_number, card_name, LocalDate.parse(expiry_date), cvv, user_id)));
    }

    @GetMapping("")
    public ResponseEntity<PaymentDao> paymentDetails(@RequestParam() long user_id) {
        return ResponseEntity.ok().body(paymentService.getPaymentDetailsByUserId(user_id));
    }

}
