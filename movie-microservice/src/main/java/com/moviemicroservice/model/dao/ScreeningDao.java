package com.moviemicroservice.model.dao;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(
        name = "screening"
)
public class ScreeningDao {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(columnDefinition = "uuid", updatable = false)
    private UUID id;

    @Column
    private double price;

    @Column
    private LocalDateTime screening_date;

    @Column
    private int screen_number;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cinema_id", referencedColumnName = "id")
    private CinemaDao cinemaDao;

    private int movieId;

    public ScreeningDao(double price, LocalDateTime screening_date, int screen_number, CinemaDao cinemaDao, int movieId) {
        this.price = price;
        this.screening_date = screening_date;
        this.screen_number = screen_number;
        this.cinemaDao = cinemaDao;
        this.movieId = movieId;
    }

    public ScreeningDao() {
    }

    public UUID getId() {
        return id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public LocalDateTime getScreening_date() {
        return screening_date;
    }

    public void setScreening_date(LocalDateTime screening_date) {
        this.screening_date = screening_date;
    }

    public int getScreen_number() {
        return screen_number;
    }

    public void setScreen_number(int screen_number) {
        this.screen_number = screen_number;
    }

    public CinemaDao getCinemaDao() {
        return cinemaDao;
    }

    public void setCinemaDao(CinemaDao cinemaDao) {
        this.cinemaDao = cinemaDao;
    }

    public int getMovie_id() {
        return movieId;
    }

    public void setMovie_id(int movieId) {
        this.movieId = movieId;
    }
}
