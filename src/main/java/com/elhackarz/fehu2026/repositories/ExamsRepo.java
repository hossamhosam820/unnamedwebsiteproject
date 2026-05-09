package com.elhackarz.fehu2026.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.elhackarz.fehu2026.models.Exams;

public interface ExamsRepo extends JpaRepository<Exams, Long> {
    List<Exams> findBySubject(String subject);
}