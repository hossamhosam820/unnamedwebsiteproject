package com.elhackarz.fehu2026.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.elhackarz.fehu2026.models.Assignments;

public interface AssignmentsRepo extends JpaRepository<Assignments, Long> {
    List<Assignments> findBySubject(String subject);
}