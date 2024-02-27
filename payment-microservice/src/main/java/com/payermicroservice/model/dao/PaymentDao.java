package com.payermicroservice.model.dao;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(
        name = "payment"
)
public class PaymentDao {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(columnDefinition = "uuid", updatable = false)
    private UUID id;

    @Column
    private String payment_type;

    @Column
    private String card_number;

    @Column
    private String card_name;

    @Column
    private LocalDate expiry_date;

    @Column
    private String cvv;

    private long user_id;

    public PaymentDao(String payment_type, String card_number, String card_name, LocalDate expiry_date, String cvv, long user_id) {
        this.payment_type = payment_type;
        this.card_number = card_number;
        this.card_name = card_name;
        this.expiry_date = expiry_date;
        this.cvv = cvv;
        this.user_id = user_id;
    }

    public PaymentDao() {

    }

    public UUID getId() {
        return id;
    }

    public String getPaymentType() {
        return payment_type;
    }

    public void setPaymentType(String payment_type) {
        this.payment_type = payment_type;
    }

    public String getCardNumber() {
        return card_number;
    }

    public void setCardNumber(String card_number) {
        this.card_number = card_number;
    }

    public String getCardName() {
        return card_name;
    }

    public void setCardName(String card_name) {
        this.card_name = card_name;
    }

    public LocalDate getExpiryDate() {
        return expiry_date;
    }

    public void setExpiryDate(LocalDate expiry_date) {
        this.expiry_date = expiry_date;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    public long getUser_id() {
        return user_id;
    }

    public void setUser_id(long user_id) {
        this.user_id = user_id;
    }
}
