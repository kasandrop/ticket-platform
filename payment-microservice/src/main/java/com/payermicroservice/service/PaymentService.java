package com.payermicroservice.service;

import com.payermicroservice.model.Payment;
import com.payermicroservice.model.dao.PaymentDao;
import com.payermicroservice.repository.PaymentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
@RequiredArgsConstructor
public class PaymentService {

    private final PaymentRepository paymentRepository;

    public PaymentDao addPaymentDetails(Payment payment) {
        PaymentDao paymentDao = new PaymentDao();
        paymentDao.setPaymentType(payment.getPayment_type());
        paymentDao.setCardNumber(payment.getCard_number());
        paymentDao.setCardName(payment.getCard_name());
        paymentDao.setExpiryDate(LocalDate.parse(payment.getExpiry_date()));
        paymentDao.setCvv(payment.getCvv());
        paymentDao.setUser_id(payment.getUser_id());
        return paymentRepository.save(paymentDao);
    }

    public PaymentDao getPaymentDetailsByUserId(long user_id) {
        return paymentRepository.findByUserId(user_id);
    }

}
