package com.payermicroservice.repository;

import com.payermicroservice.model.dao.PaymentDao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PaymentRepository extends JpaRepository<PaymentDao, UUID> {

    PaymentDao findByUserId(long userId);

}
