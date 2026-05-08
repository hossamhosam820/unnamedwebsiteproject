package com.elhackarz.fehu2026.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.elhackarz.fehu2026.models.Lectures;
import java.util.List;

public interface LecturesRepo extends JpaRepository<Lectures, Long> {

    List<Lectures> findBySubject(String subject);
}
