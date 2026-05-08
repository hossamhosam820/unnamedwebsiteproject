package com.elhackarz.fehu2026.controller;

import com.elhackarz.fehu2026.models.Lectures;
import com.elhackarz.fehu2026.repositories.LecturesRepo;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class GetURL {
    private final LecturesRepo lecturesrepo;

    public GetURL(LecturesRepo lecturesrepo) {
        this.lecturesrepo = lecturesrepo;
    }

    @GetMapping("/GetlecURL")
    public ResponseEntity<String> getLectureUrl(
            @RequestParam String subjectName,
            @RequestParam String lectureName)
    {

        Optional<Lectures> lecture = lecturesrepo.findByNameAndSubject(lectureName, subjectName);

        if (lecture.isPresent()) {
            return ResponseEntity.ok(lecture.get().getUrl());
        } else {
            return ResponseEntity.status(404).body("Lecture not found");
        }
    }

}
