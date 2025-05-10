package com.example.educationalapp.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.example.educationalapp.model.User;
import com.example.educationalapp.repository.UserRepository;

@Controller
public class LoginController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/login")
    public String login(@RequestParam String username,
                        @RequestParam String password,
                        Model model,
                        HttpSession session) {

        User user = userRepository.findByUsernameAndPassword(username, password);

        if (user != null) {
            session.setAttribute("username", username);
            return "redirect:/mainmenu";
        } else {
            model.addAttribute("error", "Λάθος όνομα χρήστη ή κωδικός.");
            return "login";
        }
    }

    @GetMapping("/login")
    public String showLoginForm() {
        return "login";
    }

    @GetMapping("/mainmenu")
    public String showMainMenu(HttpSession session, Model model) {
        String username = (String) session.getAttribute("username");
        if (username == null) {
            return "redirect:/login";
        }
        model.addAttribute("username", username);
        return "mainmenu";
    }

    @GetMapping("/register")
    public String showRegisterForm() {
        return "register";
    }

    @PostMapping("/register")
    public String handleRegister(@RequestParam String username,
                                 @RequestParam String password,
                                 Model model) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        userRepository.save(user);

        model.addAttribute("message", "Επιτυχής εγγραφή! Συνδεθείτε τώρα.");
        return "login";
    }
}
