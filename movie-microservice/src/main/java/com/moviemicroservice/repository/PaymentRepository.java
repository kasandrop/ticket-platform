package com.moviemicroservice.repository;

import com.moviemicroservice.model.dao.PaymentDao;
import com.moviemicroservice.model.dao.UserDao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PaymentRepository extends JpaRepository<PaymentDao, UUID> {

    PaymentDao findByUserDao(UserDao userDao);

}
