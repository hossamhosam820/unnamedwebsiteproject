package com.elhackarz.fehu2026.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Announcement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, length = 40, unique = false)
    private String time;
    @Column(nullable = false, length = 1000, unique = false)
    private String description;
    @Column(nullable = false, length = 40, unique = false)
    private String title;
}
