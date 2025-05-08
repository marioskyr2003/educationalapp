package com.example.educationalapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String showLoginForm() {
        return "login"; // Αντιστοιχεί στο login.html στο /resources/templates
    }
    
    @GetMapping("/mainmenu")
    public String showMainMenuPage() {
        return "mainmenu";
    }

}
