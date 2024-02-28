package com.cinemamicroservice.controller;

import com.cinemamicroservice.model.Cinema;
import com.cinemamicroservice.model.Screening;
import com.cinemamicroservice.model.Seat;
import com.cinemamicroservice.model.Ticket;
import com.cinemamicroservice.model.dao.CinemaDao;
import com.cinemamicroservice.model.dao.ScreeningDao;
import com.cinemamicroservice.model.dao.SeatDao;
import com.cinemamicroservice.model.dao.TicketDao;
import com.cinemamicroservice.service.CinemaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/api/cinema")
public class CinemaController {

    private final CinemaService cinemaService;

    public CinemaController(CinemaService cinemaService) {
        this.cinemaService = cinemaService;
    }

    // make booking > create ticket >
    @GetMapping("/booking")
    public ResponseEntity<TicketDao> booking(@RequestBody Ticket ticket)
    {
        return ResponseEntity.ok().body(cinemaService.addTicket(ticket));
    }

    @GetMapping("")
    public ResponseEntity<CinemaDao> cinemaDetails(@RequestParam() String cinema_id) {
        return ResponseEntity.ok().body(cinemaService.getCinemaById(cinema_id));
    }

    // Add cinema
    @PostMapping("/add")
    public ResponseEntity<CinemaDao> addCinema(@RequestBody Cinema cinema) {
        return ResponseEntity.ok().body(cinemaService.addCinema(cinema));
    }

    // Add Screening
    @PostMapping("/screening/add")
    public ResponseEntity<ScreeningDao> addScreening(@RequestBody Screening screening) {
        return ResponseEntity.ok().body(cinemaService.addScreening(screening));
    }

    // Add seat
    @PostMapping("/seat/add")
    public ResponseEntity<SeatDao> addSeat(@RequestBody Seat seat) {
        return ResponseEntity.ok().body(cinemaService.addSeat(seat));
    }

    @PostMapping("/ticket/add")
    public ResponseEntity<TicketDao> addTicket(@RequestBody Ticket ticket) {
        return ResponseEntity.ok().body(cinemaService.addTicket(ticket));
    }

    // Returns list of cinemas screening movie
    @GetMapping("/movie")
    public ResponseEntity<List<CinemaDao>> cinemasScreeningList(@RequestParam() int movie_id) {
        return ResponseEntity.ok().body(cinemaService.getCinemaListByMovie(movie_id));
    }

    // Returns screening details by id
    @GetMapping("/screening")
    public ResponseEntity<ScreeningDao> screeningDetails(@RequestParam() String screening_id) {
        return ResponseEntity.ok().body(cinemaService.getScreeningById(screening_id));
    }

    // Returns list of screenings by movie and cinema
    @GetMapping("/screening/movie")
    public ResponseEntity<List<ScreeningDao>> screeningDetailsList(
            @RequestParam() String cinema_id,
            @RequestParam() int movie_id) {
        return ResponseEntity.ok().body(cinemaService.getScreeningsByCinemaAndMovie(cinema_id, movie_id));
    }

    // Returns list of available seats for screening
    @GetMapping("/screening/available")
    public ResponseEntity<List<SeatDao>> screeningAvailability(@RequestParam() String screening_id) {
        return ResponseEntity.ok().body(cinemaService.getSeatsAvailableByScreening(screening_id));
    }

    @GetMapping("/screening/seat")
    public ResponseEntity<List<SeatDao>> screeningSeats(@RequestParam() String cinema_id, int screen_number) {
        return ResponseEntity.ok().body(cinemaService.getAllSeatsByCinemaIDAndScreen(cinema_id, screen_number));
    }

    // Return seat details by id
    @GetMapping("/seat")
    public ResponseEntity<SeatDao> seatDetails(@RequestParam() String seat_id) {
        return ResponseEntity.ok().body(cinemaService.getSeatById(seat_id));
    }

    // Returns ticket details by id
    @GetMapping("/ticket")
    public ResponseEntity<TicketDao> ticketDetails(@RequestParam() String ticket_id) {
        return ResponseEntity.ok().body(cinemaService.getTicketById(ticket_id));
    }

    // Returns list of users tickets
    @GetMapping("/ticket/user")
    public ResponseEntity<List<TicketDao>> userTickets(@RequestParam() long user_id) {
        return ResponseEntity.ok().body(cinemaService.getUserTickets(user_id));
    }
}
