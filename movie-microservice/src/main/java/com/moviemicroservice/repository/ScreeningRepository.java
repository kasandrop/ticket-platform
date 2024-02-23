package com.moviemicroservice.repository;

import com.moviemicroservice.model.dao.CinemaDao;
import com.moviemicroservice.model.dao.ScreeningDao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface ScreeningRepository extends JpaRepository<ScreeningDao, UUID> {
    List<ScreeningDao> findAllByMovieId(int movieId);

    List<ScreeningDao> findAllByCinemaDaoAndMovieId(CinemaDao cinemaDao, int movieId);


}
