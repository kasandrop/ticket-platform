package com.CinemaApp.Authorisation.dto;
import lombok.Data;

@Data
public class SignUpDto {
    private String name;
    private String username;
    private String email;
    private String password;
    private Boolean seller;
}