package com.elhackarz.fehu2026.controller;

import java.util.List;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.elhackarz.fehu2026.models.Lectures;
import com.elhackarz.fehu2026.repositories.LecturesRepo;

import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/api")
public class GetApi {
    private final LecturesRepo lecturesrepo;

    public GetApi(LecturesRepo lecturesrepo) {
        this.lecturesrepo = lecturesrepo;
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
