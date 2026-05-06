package com.elhackarz.fehu2026.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import com.elhackarz.fehu2026.models.Subjects;

public interface SubjectsRepo extends JpaRepository<Subjects, Long> {
    List<Subjects> findAll();
}
