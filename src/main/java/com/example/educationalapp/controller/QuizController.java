package com.example.educationalapp.controller;

import com.example.educationalapp.model.QuizResult;
import com.example.educationalapp.repository.QuizResultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Controller
public class QuizController {

    @Autowired
    private QuizResultRepository quizResultRepository;

    @PostMapping("/submitQuiz/{unit}")
    public String submitQuiz(
            @PathVariable int unit,
            @RequestParam String username,
            @RequestParam Map<String, String> allParams,
            Model model) {

        int score = 0;

        Map<String, String> correctAnswers = new HashMap<>();

        if (unit == 1) {
            correctAnswers.put("q1", "true");
            correctAnswers.put("q2", "false");
            correctAnswers.put("q3", "true");
            correctAnswers.put("q4", "false");
            correctAnswers.put("q5", "true");
            correctAnswers.put("q6", "false");
            correctAnswers.put("q7", "true");
            correctAnswers.put("q8", "false");
            correctAnswers.put("q9", "false");
            correctAnswers.put("q10", "true");
        } else if (unit == 2) {
            correctAnswers.put("q1", "true");
            correctAnswers.put("q2", "false");
            correctAnswers.put("q3", "true");
            correctAnswers.put("q4", "false");
            correctAnswers.put("q5", "true");
            correctAnswers.put("q6", "false");
            correctAnswers.put("q7", "true");
            correctAnswers.put("q8", "false");
            correctAnswers.put("q9", "true");
            correctAnswers.put("q10", "false");
        } else if (unit == 3) {
            correctAnswers.put("q1", "true");
            correctAnswers.put("q2", "false");
            correctAnswers.put("q3", "true");
            correctAnswers.put("q4", "false");
            correctAnswers.put("q5", "true");
            correctAnswers.put("q6", "false");
            correctAnswers.put("q7", "true");
            correctAnswers.put("q8", "true");
            correctAnswers.put("q9", "false");
            correctAnswers.put("q10", "true");
        } else {
            model.addAttribute("message", "Άγνωστη ενότητα.");
            return "quizResult";
        }

        // Μέτρηση σκορ
        for (Map.Entry<String, String> entry : correctAnswers.entrySet()) {
            String qKey = entry.getKey();
            String correct = entry.getValue();
            String submitted = allParams.get(qKey);

            if (submitted != null && correct.equals(submitted)) {
                score++;
            }
        }

        Optional<QuizResult> existingResult = quizResultRepository.findByUsernameAndUnitNumber(username, unit);

        if (existingResult.isPresent()) {
            QuizResult result = existingResult.get();
            model.addAttribute("message", "Έχεις ήδη κάνει το quiz με σκορ " + result.getScore() +
                    ". Ενημερώνεται με νέο σκορ: " + score);
            result.setScore(score);
            quizResultRepository.save(result);
        } else {
            QuizResult newResult = new QuizResult();
            newResult.setUsername(username);
            newResult.setUnitNumber(unit);
            newResult.setScore(score);
            quizResultRepository.save(newResult);
            model.addAttribute("message", "Το σκορ σου αποθηκεύτηκε: " + score);
        }

        return "quizResult";
    }
}
