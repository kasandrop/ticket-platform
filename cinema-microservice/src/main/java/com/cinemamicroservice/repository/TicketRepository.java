package com.cinemamicroservice.repository;

import com.cinemamicroservice.model.dao.ScreeningDao;
import com.cinemamicroservice.model.dao.TicketDao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface TicketRepository extends JpaRepository<TicketDao, UUID> {

    List<TicketDao> findAllByUser_id(long user_id);

    List<TicketDao> findAllByScreeningDao(ScreeningDao screeningDao);

}
