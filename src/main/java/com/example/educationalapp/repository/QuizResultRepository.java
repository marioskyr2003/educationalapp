package com.example.educationalapp.repository;

import com.example.educationalapp.model.QuizResult;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface QuizResultRepository extends JpaRepository<QuizResult, Long> {
    Optional<QuizResult> findByUsernameAndUnitNumber(String username, int unitNumber);
} 



