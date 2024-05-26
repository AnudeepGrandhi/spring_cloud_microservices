package com.example.quiz.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.quiz.Repository.QuizRepository;
import com.example.quiz.modal.Quiz;

@Service
public class QuizService {

	@Autowired
	QuizRepository quizRepository;
	
	public Quiz getQuizById(int id) {
		return quizRepository.findById(id).get();
	}
	
	public Quiz createQuiz(Quiz quiz) {
		return quizRepository.save(quiz);
	}
	
	public List<Quiz> getQuizs() {
		return quizRepository.findAll();
	}
	
}
