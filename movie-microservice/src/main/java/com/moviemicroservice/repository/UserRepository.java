package com.moviemicroservice.repository;

import com.moviemicroservice.model.dao.UserDao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<UserDao, UUID> {

    UserDao findByUsernameAndPassword(String user, String pass);

}
