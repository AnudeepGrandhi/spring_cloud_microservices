package com.example.questions.controller;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.bootstrap.BootstrapConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.example.questions.dto.QuizDTO;
import com.example.questions.modal.Question;
import com.example.questions.response.BadResponse;
import com.example.questions.service.QuestionService;

@RestController
@RequestMapping("/api")
@EnableJpaRepositories
public class QuestionController {
	
	@Autowired
	QuestionService questionService;
	
	@Value("${quiz.quizuri}")
	String quizUri;
	
	@RequestMapping("/question/{id}")
	public ResponseEntity<Object> getQuestionById(@PathVariable Long id) {
		try {
	    	return new ResponseEntity<Object>(questionService.getQuestionById(id), HttpStatus.OK);
		} catch(NoSuchElementException e) {
			return new ResponseEntity<Object>(new BadResponse("failure", "Question Not Found"), HttpStatus.NOT_FOUND);
		} 
	}
	
	@RequestMapping("/question")
	public ResponseEntity<Object> createQuiz(@RequestBody Question question) {
		
		if (question.getCorrect_option() != null && question.getName() != null && question.getOptions() != null
				&& question.getPoints() != null && question.getQuiz() != 0) {
			try {
      			QuizDTO quiz = new RestTemplate().getForObject(quizUri+question.getQuiz(), QuizDTO.class);
				return new ResponseEntity<Object>(questionService.createQuestion(question), HttpStatus.CREATED);
			} catch(HttpClientErrorException ex) {
				return new ResponseEntity<Object>(new BadResponse("failure", "Quiz Not Found"), HttpStatus.NOT_FOUND);
			}
		}
		
		return new ResponseEntity<Object>(new BadResponse("failure", "Not all fields are present in Request"), HttpStatus.BAD_REQUEST);
	}
	
	@RequestMapping("/questions/{quizId}")
	public ResponseEntity<Object> getQuestionsByQuiz(@PathVariable int quizId) {
		try {
  			QuizDTO quiz = new RestTemplate().getForObject(quizUri+quizId, QuizDTO.class);
			return new ResponseEntity<Object>(questionService.getQuestionsByQuiz(quizId), HttpStatus.OK);
		} catch(HttpClientErrorException ex) {
			return new ResponseEntity<Object>(new BadResponse("failure", "Quiz Not Found"), HttpStatus.NOT_FOUND);
		} 
	}

}
