package com.cinemamicroservice.service;

import com.cinemamicroservice.model.dao.CinemaDao;
import com.cinemamicroservice.model.dao.ScreeningDao;
import com.cinemamicroservice.model.dao.SeatDao;
import com.cinemamicroservice.model.dao.TicketDao;
import com.cinemamicroservice.repository.CinemaRepository;
import com.cinemamicroservice.repository.ScreeningRepository;
import com.cinemamicroservice.repository.SeatRepository;
import com.cinemamicroservice.repository.TicketRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class CinemaService {

    private final SeatRepository seatRepository;
    private final TicketRepository ticketRepository;
    private final ScreeningRepository screeningRepository;
    private final CinemaRepository cinemaRepository;

    public CinemaDao addCinema(CinemaDao cinemaDao) {
        return cinemaRepository.save(cinemaDao);
    }

    public ScreeningDao addScreening(ScreeningDao screeningDao) {
        return screeningRepository.save(screeningDao);
    }

    public SeatDao addSeat(SeatDao seatDao) {
        return seatRepository.save(seatDao);
    }

    public TicketDao addTicket(TicketDao ticketDao) {
        return ticketRepository.save(ticketDao);
    }

    public List<TicketDao> getUserTickets(long user_id) {
        return ticketRepository.findAllByUserId(user_id);
    }

    public CinemaDao getCinemaById(String cinema_id) {
        return cinemaRepository.findById(UUID.fromString(cinema_id)).get();
    }

    public ScreeningDao getScreeningById(String screening_id) {
        return screeningRepository.findById(UUID.fromString(screening_id)).get();
    }

    public SeatDao getSeatById(String seat_id) {
        return seatRepository.findById(UUID.fromString(seat_id)).get();
    }

    public TicketDao getTicketById(String ticket_id) {
        return ticketRepository.findById(UUID.fromString(ticket_id)).get();
    }

    public List<CinemaDao> getCinemaListByMovie(int movie_id) {
        List<ScreeningDao> screeningList = screeningRepository.findAllByMovieId(movie_id);
        List<CinemaDao> cinemaList = new ArrayList<>();
        for (ScreeningDao screeningDao : screeningList) {
            cinemaList.add(cinemaRepository.findById(screeningDao.getCinemaDao().getId()).get());
        }
        return cinemaList.stream()
            .collect(Collectors.toMap(v -> v.getId(),
                v -> v,
                (a, b) -> a
            )).values().stream().toList();
    }

    public List<ScreeningDao> getScreeningsByCinemaAndMovie(String cinema_id, int movie_id) {
        return screeningRepository.findAllByCinemaDaoAndMovieId(getCinemaById(cinema_id), movie_id);
    }

    public List<SeatDao> getAllSeatsByCinemaIDAndScreen(String cinema_id, int screen_number) {
        return seatRepository.findAllByCinemaDaoAndScreenNumber(getCinemaById(cinema_id), screen_number);
    }

    public List<SeatDao> getAllSeatsByCinemaAndScreen(CinemaDao cinema, int screen_number) {
        return seatRepository.findAllByCinemaDaoAndScreenNumber(cinema, screen_number);
    }

    public List<SeatDao> getSeatsAvailableByScreening(String screening_id) {
        ScreeningDao screening = getScreeningById(screening_id);
        List<TicketDao> purcahsedTicketList = ticketRepository.findAllByScreeningDao(screening);

        if (purcahsedTicketList.isEmpty()) {
            return getAllSeatsByCinemaAndScreen(screening.getCinemaDao(), screening.getScreen_number());
        }

        return seatRepository.findAllAvailableSeats(
                purcahsedTicketList,
                screening.getCinemaDao().getId(),
                screening.getScreen_number()
        );
    }

}
