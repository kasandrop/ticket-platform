package com.moviemicroservice.repository;

import com.moviemicroservice.model.dao.ScreeningDao;
import com.moviemicroservice.model.dao.TicketDao;
import com.moviemicroservice.model.dao.UserDao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface TicketRepository extends JpaRepository<TicketDao, UUID> {

    List<TicketDao> findAllByUserDao(UserDao userDao);

    List<TicketDao> findAllByScreeningDao(ScreeningDao screeningDao);

}
