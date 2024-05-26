package com.example.quiz.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.quiz.modal.Quiz;

@Repository
public interface QuizRepository extends JpaRepository<Quiz, Integer>{

}
