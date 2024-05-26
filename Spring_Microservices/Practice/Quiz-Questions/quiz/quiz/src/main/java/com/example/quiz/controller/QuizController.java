package com.example.quiz.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.quiz.dto.QuestionDTO;
import com.example.quiz.dto.QuizDTO;
import com.example.quiz.modal.Quiz;
import com.example.quiz.response.BadResponse;
import com.example.quiz.service.QuizService;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class QuizController {
	
	@Autowired
	QuizService quizService;
	
	@Value("${question.questionUri}")
	String questionUri;
	
	@RequestMapping(value = "/quiz/{id}")
	public ResponseEntity<Object> getQuizById(@PathVariable int id) {
	    try {
	    	return new ResponseEntity<Object>(quizService.getQuizById(id), HttpStatus.OK);
		} catch(NoSuchElementException e) {
			return new ResponseEntity<Object>(new BadResponse("failure", "Quiz Not Found"), HttpStatus.NOT_FOUND);
		} 
	}
	
	@RequestMapping(value = "/quizes/")
	public ResponseEntity<Object> getQuizs() {
	    try {
	    	return new ResponseEntity<Object>(quizService.getQuizs(), HttpStatus.OK);
		} catch(NoSuchElementException e) {
			return new ResponseEntity<Object>(new BadResponse("failure", "Quiz Not Found"), HttpStatus.NOT_FOUND);
		} 
	}
	
	@RequestMapping("/quiz")
	public ResponseEntity<Object> createQuiz(@RequestBody Quiz quiz) {
		
		if(quiz.getName() != "" && quiz.getDescription() != "") {
			return new ResponseEntity<Object>(quizService.createQuiz(quiz), HttpStatus.CREATED);
		}
		
		return new ResponseEntity<Object>(new BadResponse("failure", "Not all fields are present in Request"), HttpStatus.NOT_FOUND);
	}

	@RequestMapping(value = "/quiz-questions/{id}")
	public ResponseEntity<Object> getQuizQuestions(@PathVariable int id) {
	    try {
	    	Quiz quiz = quizService.getQuizById(id);
	    	List<QuestionDTO> questions = (List<QuestionDTO>) new RestTemplate().getForObject(questionUri+id, List.class);
	    	
	    	QuizDTO quizDTO = new QuizDTO();
	    	quizDTO.setName(quiz.getName());
	    	quizDTO.setDescription(quiz.getDescription());
	    	quizDTO.setQuestions(questions);
	    	
	    	return new ResponseEntity<Object>(quizDTO, HttpStatus.OK);
		} catch(NoSuchElementException e) {
			return new ResponseEntity<Object>(new BadResponse("failure", "Quiz Not Found"), HttpStatus.NOT_FOUND);
		} 
	}
	
}
