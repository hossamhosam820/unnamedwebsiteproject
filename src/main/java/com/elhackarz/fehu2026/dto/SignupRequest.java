package com.elhackarz.fehu2026.dto;
import java.time.LocalDate;

import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.Data;
@Data
public class SignupRequest {
    private String name;
    private String username;
    private String email;
    private String password;
    @DecimalMax(value = "4.0", message = "GPA cannot be more than 4")
    private Double gpa;
    private LocalDate birthDate;
@Min(value = 1, message = "Academic year cannot be less than 1")
@Max(value = 4, message = "Academic year cannot be more than 4")
    private Integer acyear; //Acadimic year ya sohaib


}