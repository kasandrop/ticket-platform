package com.CinemaApp.Authorisation.service;

import com.CinemaApp.Authorisation.dao.UserRepo;
import com.CinemaApp.Authorisation.model.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserService implements UserDetailsService {

    private UserRepo userDao;

    public UserService(UserRepo userDao) { this.userDao = userDao; }

    @Override
    public UserDetails loadUserByUsername(String usernameOrEmail) throws UsernameNotFoundException {
        User user = userDao.findByUsernameOrEmail(usernameOrEmail, usernameOrEmail)
                .orElseThrow(() ->
                        new UsernameNotFoundException("User Not Found with:" + usernameOrEmail));
            Set<GrantedAuthority> authorities = user
                    .getRoles()
                    .stream()
                    .map((role) -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toSet());

            return new org.springframework.security.core.userdetails.User(user.getEmail(),
                    user.getPassword(),
                    authorities);

    }
}
