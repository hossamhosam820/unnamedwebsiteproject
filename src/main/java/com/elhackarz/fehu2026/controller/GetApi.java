package com.elhackarz.fehu2026.controller;

import java.util.List;
import org.springframework.web.bind.annotation.*;
import com.elhackarz.fehu2026.models.Lectures;
import com.elhackarz.fehu2026.models.Subjects;
import com.elhackarz.fehu2026.repositories.LecturesRepo;
import com.elhackarz.fehu2026.repositories.SubjectsRepo;

@RestController
@RequestMapping("/api")
public class GetApi {
    private final LecturesRepo lecturesrepo;
    private final SubjectsRepo subjectsrepo;

    public GetApi(LecturesRepo lecturesrepo, SubjectsRepo subjectsrepo) {
        this.lecturesrepo = lecturesrepo;
        this.subjectsrepo = subjectsrepo;
    }

    @GetMapping("/all-lectures")
    public List<Lectures> getAllLectures() {
        return lecturesrepo.findAll();
    }
    
    @PostMapping("/subjects")
        public Subjects addSubject(@RequestBody Subjects subject) {
        return subjectsrepo.save(subject);
    }

    @PostMapping("/add-lecture") 
        public Lectures addLecture(@RequestBody Lectures lecture) {
      return lecturesrepo.save(lecture);
    }

   @GetMapping("/lectures-by-subject")
    public List<Lectures> getBySubject(@RequestParam String name) {
        return lecturesrepo.findBySubject(name);
    }

    @GetMapping("/getlectures")
    public List<Lectures> getLectures() {
        return lecturesrepo.findAll();
    }

    @GetMapping("/hello")
    public String hello() {
        return "Hello, World!";
    }

}
