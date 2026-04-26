package com.elhackarz.fehu2026.controller;
import java.util.List;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.elhackarz.fehu2026.models.Lectures;
import com.elhackarz.fehu2026.repositories.LecturesRepo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    @GetMapping("/secret_resource")
    public ResponseEntity<String> secret() {
        return new ResponseEntity<>("You are viewing my secret", HttpStatus.OK);}
    @GetMapping("/public_resource")
    public ResponseEntity<String> nosecret() {
        return new ResponseEntity<>("You are in public area", HttpStatus.OK);}
}
