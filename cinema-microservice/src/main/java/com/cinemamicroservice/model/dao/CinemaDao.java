package com.cinemamicroservice.model.dao;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(
        name = "cinema"
)
public class CinemaDao {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(columnDefinition = "uuid", updatable = false)
    private UUID id;

    @Column
    private String name;

    @Column
    private String company_name;

    @Column
    private String address;

    @Column
    private String city;

    @Column
    private String province;

    @Column
    private String country;

    @Column
    private String postcode;

    @Column
    private LocalDateTime registered_date;

    @Column
    private int screens;

    public CinemaDao(String name, String company_name, String address, String city, String province, String country, String postcode, LocalDateTime registered_date, int screens) {
        this.name = name;
        this.company_name = company_name;
        this.address = address;
        this.city = city;
        this.province = province;
        this.country = country;
        this.postcode = postcode;
        this.registered_date = registered_date;
        this.screens = screens;
    }

    public CinemaDao() {
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCompanyName() {
        return company_name;
    }

    public void setCompanyName(String company_name) {
        this.company_name = company_name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public LocalDateTime getRegisteredDate() {
        return registered_date;
    }

    public void setRegisteredDate(LocalDateTime registered_date) {
        this.registered_date = registered_date;
    }

    public int getScreens() {
        return screens;
    }

    public void setScreens(int screens) {
        this.screens = screens;
    }
}
