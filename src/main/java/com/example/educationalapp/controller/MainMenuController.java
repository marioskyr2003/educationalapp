package com.example.educationalapp.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainMenuController {
	
	@GetMapping("/mainmenu")
	public String showMainMenu(HttpSession session, Model model) {
	    String username = (String) session.getAttribute("username");
	    model.addAttribute("username", username);
	    System.out.println("testestaijsofdjiasojfoiasjdofj");
	    return "mainmenu";
	}

    @GetMapping("/unit1")
    public String showUnit1Page(HttpSession session, Model model) {
        model.addAttribute("username", session.getAttribute("username"));
        return "unit1";
    }

    @GetMapping("/unit1quiz")
    public String showUnit1quizPage(HttpSession session, Model model) {
        model.addAttribute("username", session.getAttribute("username"));
        return "unit1quiz";
    }

    @GetMapping("/unit2")
    public String showUnit2Page(HttpSession session, Model model) {
        model.addAttribute("username", session.getAttribute("username"));
        return "unit2";
    }

    @GetMapping("/unit2quiz")
    public String showUnit2quizPage(HttpSession session, Model model) {
        model.addAttribute("username", session.getAttribute("username"));
        return "unit2quiz";
    }

    @GetMapping("/unit3")
    public String showUnit3Page(HttpSession session, Model model) {
        model.addAttribute("username", session.getAttribute("username"));
        return "unit3";
    }

    @GetMapping("/unit3quiz")
    public String showUnit3quizPage(HttpSession session, Model model) {
        model.addAttribute("username", session.getAttribute("username"));
        return "unit3quiz";
    }
}
