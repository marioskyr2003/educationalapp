package com.example.educationalapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainMenuController {

    @GetMapping("/unit1")
    public String showUnit1Page() {
        return "unit1";
    }
    
    @GetMapping("/unit2")
    public String showUnit2Page() {
        return "unit2";
    }
    
    @GetMapping("/unit3")
    public String showUnit3Page() {
        return "unit3";
    }
}
