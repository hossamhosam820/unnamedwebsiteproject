package com.elhackarz.fehu2026.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.elhackarz.fehu2026.models.Lectures;
import java.util.List;

import java.util.Optional;

public interface LecturesRepo extends JpaRepository<Lectures, Long> {

    Optional<Lectures> findByName(String name);

    Optional<Lectures> findByNameAndSubject(String name, String subject);

    int countBySubject(String subject);

    List<Lectures> findBySubject(String subject);
}
