package com.elhackarz.fehu2026.controller;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

import com.elhackarz.fehu2026.models.Announcement;
import com.elhackarz.fehu2026.models.Exams;
import com.elhackarz.fehu2026.models.Lectures;
import com.elhackarz.fehu2026.models.Subjects;
import com.elhackarz.fehu2026.models.User;
import com.elhackarz.fehu2026.repositories.AnnouncementRepo;
import com.elhackarz.fehu2026.repositories.ExamsRepo;
import com.elhackarz.fehu2026.repositories.LecturesRepo;
import com.elhackarz.fehu2026.repositories.SubjectsRepo;
import com.elhackarz.fehu2026.repositories.UserRepository;

@RestController
@RequestMapping("/api")
public class GetApi {
    private final LecturesRepo lecturesrepo;
    private final SubjectsRepo subjectsrepo;
    private final AnnouncementRepo announcementrepo;
    private final ExamsRepo examsrepo;
    private final UserRepository userrepo;

    public GetApi(LecturesRepo lecturesrepo, SubjectsRepo subjectsrepo, AnnouncementRepo announcementrepo,
            ExamsRepo examsrepo, UserRepository userrepo) {
        this.lecturesrepo = lecturesrepo;
        this.subjectsrepo = subjectsrepo;
        this.announcementrepo = announcementrepo;
        this.examsrepo = examsrepo;
        this.userrepo = userrepo;
    }

    @PostMapping("/addsubject")
    public RedirectView addSubject(@ModelAttribute Subjects subject) {
        subjectsrepo.save(subject);
        return new RedirectView("/home?subject");
    }

    @PostMapping("/addlecture")
    public RedirectView addLecture(@ModelAttribute Lectures lecture) {
        lecturesrepo.save(lecture);
        return new RedirectView("/home?subject=" + lecture.getSubject());
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

    @PostMapping("/addannouncement")
    public RedirectView addAnnouncement(@ModelAttribute Announcement announcement) {
        announcement.setTime(LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy\t\t\tHH:mm:ss")));
        announcementrepo.save(announcement);
        return new RedirectView("/home?announcements");
    }

    @GetMapping("/getexamsbysubject")
    public List<Exams> getExamsBySubject(@RequestParam String name) {
        return examsrepo.findBySubject(name);
    }

    @PostMapping("/addexam")
    public RedirectView addExam(@ModelAttribute Exams exam) {
        examsrepo.save(exam);
        return new RedirectView("/home?exam=" + exam.getSubject());
    }

    @GetMapping("/getprofile")
    public Optional<User> getProfile() {
        String currEmail = SecurityContextHolder.getContext().getAuthentication().getName();
        return userrepo.findByEmail(currEmail);
    }

    @GetMapping("/isadmin")
    public Boolean isAdmin() {
        String currEmail = SecurityContextHolder.getContext().getAuthentication().getName();
        User currUser = userrepo.findByEmail(currEmail).orElse(new User());
        if (currUser.getRole().equals("ROLE_ADMIN")) {
            return true;
        } else
            return false;
    }

}
