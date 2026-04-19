package com.elhackarz.fehu2026;

import java.util.List;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;



@RestController
@RequestMapping("/api")
public class getapi {
    private final lecturesrepo lecturesrepo;
    public getapi(lecturesrepo lecturesrepo){this.lecturesrepo = lecturesrepo;}
    @GetMapping("/getlectures")
    public List<lectures> getLectures() {
        return lecturesrepo.findAll();
    }
    @GetMapping("/hello")
    public String hello() {
        return "Hello, World!";
    }
    
    
}
