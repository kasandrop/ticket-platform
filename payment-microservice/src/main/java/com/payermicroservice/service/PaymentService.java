package com.payermicroservice.service;

import com.payermicroservice.model.dao.PaymentDao;
import com.payermicroservice.repository.PaymentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PaymentService {

    private final PaymentRepository paymentRepository;

    public PaymentDao addPaymentDetails(PaymentDao paymentDao) {
        return paymentRepository.save(paymentDao);
    }

    public PaymentDao getPaymentDetailsByUserId(long user_id) {
        return paymentRepository.findByUserId(user_id);
    }

}
