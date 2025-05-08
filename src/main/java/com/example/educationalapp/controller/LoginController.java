package com.example.educationalapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.example.educationalapp.model.User;
import com.example.educationalapp.repository.UserRepository;
import org.springframework.ui.Model;

@Controller
public class LoginController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password, Model model) {
        User user = userRepository.findByUsernameAndPassword(username, password);
        if (user != null) {
            return "mainmenu";  // Επιτυχία -> πήγαινε στο mainmenu.html
        } else {
            model.addAttribute("error", "Invalid username or password");
            return "login";  // Αποτυχία -> μείνε στη login.html και δείξε μήνυμα
        }
    }

    @GetMapping("/login")
    public String showLoginForm() {
        return "login";
    }
    
    @GetMapping("/mainmenu")
    public String showMainMenu() {
        return "mainmenu";
    }
    
    @GetMapping("/register")
    public String Register() {
    	return "register";
    }
    
    @PostMapping("/register")
    public String handleRegister(@RequestParam String username, @RequestParam String password, Model model) {
        // Σύνδεση με βάση
        User user = new User();
        user.setUsername(username);
        user.setPassword(password); 
        userRepository.save(user);

        model.addAttribute("message", "Επιτυχής εγγραφή! Συνδεθείτε τώρα.");
        return "login"; // 
    }
}

