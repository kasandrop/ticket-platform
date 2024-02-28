package com.cinemamicroservice.repository;

import com.cinemamicroservice.model.dao.CinemaDao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CinemaRepository extends JpaRepository<CinemaDao, UUID> {
}
