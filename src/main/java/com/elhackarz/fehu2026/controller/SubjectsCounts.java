package com.elhackarz.fehu2026.controller;

import java.util.List;
import java.util.stream.Collectors;

import com.elhackarz.fehu2026.models.Subjects;
import com.elhackarz.fehu2026.repositories.LecturesRepo;
import com.elhackarz.fehu2026.repositories.SubjectsRepo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SubjectsCounts {
    private final LecturesRepo lecturesrepo;
    private final SubjectsRepo Subjectsrepo;

    public SubjectsCounts(LecturesRepo lecturesrepo, SubjectsRepo subjectsrepo) {
        this.lecturesrepo = lecturesrepo;
        this.Subjectsrepo = subjectsrepo;
    }

    @GetMapping("/subjectsCount")
    public List<Subjects> getSubjectsCount() {

        List<Subjects> subjects = Subjectsrepo.findAll();
        return subjects.stream()
                .map(subject -> {
                    int count = lecturesrepo.countBySubject(subject.getName());
                    return new Subjects();
                })
                .collect(Collectors.toList());
    }
}
