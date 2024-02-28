package com.CinemaApp.Authorisation.api;

import com.CinemaApp.Authorisation.dao.RoleRepo;
import com.CinemaApp.Authorisation.dao.UserRepo;
import com.CinemaApp.Authorisation.dto.LoginDto;
import com.CinemaApp.Authorisation.dto.RoleDto;
import com.CinemaApp.Authorisation.dto.SignUpDto;
import com.CinemaApp.Authorisation.model.Role;
import com.CinemaApp.Authorisation.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;

@RequestMapping("api/auth")
@RestController
public class LoginController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private RoleRepo roleRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/signin")
    public ResponseEntity<String> authenticateUser(@RequestBody LoginDto loginDto){
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                loginDto.getUsernameOrEmail(), loginDto.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        return new ResponseEntity<>("User signed-in successfully!.", HttpStatus.OK);
    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@RequestBody SignUpDto signUpDto){

        // add check for username exists in a DB
        if(userRepo.existsByUsername(signUpDto.getUsername())){
            return new ResponseEntity<>("Username is already taken!", HttpStatus.BAD_REQUEST);
        }

        // add check for email exists in DB
        if(userRepo.existsByEmail(signUpDto.getEmail())){
            return new ResponseEntity<>("Email is already taken!", HttpStatus.BAD_REQUEST);
        }

        // create user object
        User user = new User();
        user.setName(signUpDto.getName());
        user.setUsername(signUpDto.getUsername());
        user.setEmail(signUpDto.getEmail());
        user.setPassword(passwordEncoder.encode(signUpDto.getPassword()));

        if(signUpDto.getSeller()) {
            Role roles = roleRepo.findByName("ROLE_SELLERS").get();
            user.setRoles(Collections.singleton(roles));
        } else {
            Role roles = roleRepo.findByName("ROLE_USERS").get();
            user.setRoles(Collections.singleton(roles));
        }
        userRepo.save(user);

        return new ResponseEntity<>(user, HttpStatus.OK);

    }

    @GetMapping("/getUser")
    ResponseEntity<User> userDetails(@RequestParam() long user_id) {
        return ResponseEntity.ok().body(userRepo.findById(user_id).get());
    }

    @PostMapping("/role/add")
    ResponseEntity<String> addRole(@RequestBody() RoleDto roleDto) {
        Role role = new Role();
        role.setName(roleDto.getName());
        roleRepo.save(role);
        return ResponseEntity.ok().body(role.getName() + " Role Added");
    }


}
