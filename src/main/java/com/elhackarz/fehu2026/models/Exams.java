package com.elhackarz.fehu2026.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Exams {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 40, unique = false)
    private String name;
    @Column(nullable = false, length = 500, unique = true)
    private String url;
    @Column(nullable = false, length = 40, unique = false)
    private String subject;

}