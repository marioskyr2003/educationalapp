package com.example.educationalapp.model;

import jakarta.persistence.*;

@Entity
public class QuizResult {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username; 

    private int unitNumber;

    private int score;

    // Getters & Setters
    public Long getId() { 
    	return id; 
    }
    
    public void setId(Long id) { 
    	this.id = id; 
    }

    public String getUsername() { 
    	return username; 
    }
    public void setUsername(String username) { 
    	this.username = username; 
    }

    public int getUnitNumber() { 
    	return unitNumber; 
    }
    
    public void setUnitNumber(int unitNumber) { 
    	this.unitNumber = unitNumber; 
    }

    public int getScore() { 
    	return score; 
    }
    
    public void setScore(int score) { 
    	this.score = score; 
    }
}
