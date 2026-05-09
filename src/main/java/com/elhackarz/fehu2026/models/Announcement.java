package com.elhackarz.fehu2026.models;

import org.springframework.data.annotation.Id;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.Data;

@Data
@Entity
public class Announcement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 40, unique = true)
    private String time;
    @Column(nullable = false, length = 1000, unique = false)
    private String description;
    @Column(nullable = false, length = 40, unique = false)
    private String title;
}
