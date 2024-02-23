package com.moviemicroservice.model.dao;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(
        name = "ticket"
)
public class TicketDao {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(columnDefinition = "uuid", updatable = false)
    private UUID id;

    @Column
    private LocalDateTime booking_date;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "screening_id", referencedColumnName = "id")
    private ScreeningDao screeningDao;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "seat_id", referencedColumnName = "id")
    private SeatDao seatDao;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private UserDao userDao;

    public TicketDao(LocalDateTime booking_date, ScreeningDao screeningDao, SeatDao seatDao, UserDao userDao) {
        this.booking_date = booking_date;
        this.screeningDao = screeningDao;
        this.seatDao = seatDao;
        this.userDao = userDao;
    }

    public TicketDao() {
    }

    public UUID getId() {
        return id;
    }

    public LocalDateTime getBooking_date() {
        return booking_date;
    }

    public void setBooking_date(LocalDateTime booking_date) {
        this.booking_date = booking_date;
    }

    public ScreeningDao getScreeningDao() {
        return screeningDao;
    }

    public void setScreeningDao(ScreeningDao screeningDao) {
        this.screeningDao = screeningDao;
    }

    public SeatDao getSeatDao() {
        return seatDao;
    }

    public void setSeatDao(SeatDao seatDao) {
        this.seatDao = seatDao;
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
}
