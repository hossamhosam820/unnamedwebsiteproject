package com.elhackarz.fehu2026;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;



@Controller
public class homepage {
    @GetMapping("/")
    public String index() {
        return  "index.html";
    } 
    
}
