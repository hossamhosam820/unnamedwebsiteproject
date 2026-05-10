package com.elhackarz.fehu2026.dto;

import java.time.LocalDate;

import lombok.Data;

@Data
public class SignupRequest {
    private String name;
    private String username;
    private String email;
    private String password;
    private double gpa;
    private int birthyear;
}
