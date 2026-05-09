package com.elhackarz.fehu2026.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.elhackarz.fehu2026.models.Announcement;
import com.elhackarz.fehu2026.models.Assignments;
import com.elhackarz.fehu2026.models.Exams;
import com.elhackarz.fehu2026.models.Lectures;
import com.elhackarz.fehu2026.models.Subjects;
import com.elhackarz.fehu2026.repositories.AnnouncementRepo;
import com.elhackarz.fehu2026.repositories.AssignmentsRepo;
import com.elhackarz.fehu2026.repositories.ExamsRepo;
import com.elhackarz.fehu2026.repositories.LecturesRepo;
import com.elhackarz.fehu2026.repositories.SubjectsRepo;

@RestController
@RequestMapping("/api")
public class GetApi {
    private final LecturesRepo lecturesrepo;
    private final SubjectsRepo subjectsrepo;
    private final AnnouncementRepo announcementrepo;
    private final ExamsRepo examsrepo;
    private final AssignmentsRepo assignmentsrepo;

    public GetApi(LecturesRepo lecturesrepo, SubjectsRepo subjectsrepo, AnnouncementRepo announcementrepo,
            ExamsRepo examsrepo, AssignmentsRepo assignmentsrepo) {
        this.lecturesrepo = lecturesrepo;
        this.subjectsrepo = subjectsrepo;
        this.announcementrepo = announcementrepo;
        this.examsrepo = examsrepo;
        this.assignmentsrepo = assignmentsrepo;
    }

    @PostMapping("/addsubject")
    public Subjects addSubject(@RequestBody Subjects subject) {
        return subjectsrepo.save(subject);
    }

    @PostMapping("/addlecture")
    public Lectures addLecture(@RequestBody Lectures lecture) {
        return lecturesrepo.save(lecture);
    }

    @GetMapping("/lecturesbysubject")
    public List<Lectures> getBySubject(@RequestParam String name) {
        return lecturesrepo.findBySubject(name);
    }

    @GetMapping("/getlectures")
    public List<Lectures> getLectures() {
        return lecturesrepo.findAll();
    }

    @GetMapping("/getsubjects")
    public List<Subjects> getSubjects() {
        return subjectsrepo.findAll();
    }

    @GetMapping("/getannouncements")
    public List<Announcement> announcementDisplay() {
        return announcementrepo.findAll();
    }

    @PostMapping("/addannouncements")
    public void addAnnouncement(@RequestBody Announcement announcement) {
        announcementrepo.save(announcement);
    }

    @GetMapping("/getexams")
    public List<Exams> getExamsBySubject(@RequestParam String subject) {
        return examsrepo.findBySubject(subject);
    }

    @GetMapping("/getassignments")
    public List<Assignments> getAssignmentsBySubject(@RequestParam String subject) {
        return assignmentsrepo.findBySubject(subject);
    }
}
