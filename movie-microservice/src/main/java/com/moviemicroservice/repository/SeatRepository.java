package com.moviemicroservice.repository;

import com.moviemicroservice.model.dao.CinemaDao;
import com.moviemicroservice.model.dao.SeatDao;
import com.moviemicroservice.model.dao.TicketDao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface SeatRepository extends JpaRepository<SeatDao, UUID> {

    @Query("SELECT s FROM SeatDao s " +
            "WHERE s.cinemaDao.id = :cinemaId " +
            "AND s.screenNumber = :screenNumber " +
            "AND s.id NOT IN (SELECT t.seatDao.id FROM TicketDao t WHERE t in :ticket)")
    List<SeatDao> findAllAvailableSeats(@Param("ticket") List<TicketDao> ticketDao,
                                        @Param("cinemaId") UUID cinemaDao,
                                        @Param("screenNumber") int screen_number);

    List<SeatDao> findAllByCinemaDaoAndScreenNumber(CinemaDao cinemaDao, int screenNumber);
}
