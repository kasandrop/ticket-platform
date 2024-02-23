package com.sellermicroservice;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SellerRepository extends JpaRepository<Seller, Integer> {
    Seller findByEmail(String email);

}
