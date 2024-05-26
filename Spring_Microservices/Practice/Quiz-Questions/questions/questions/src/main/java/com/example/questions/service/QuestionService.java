package com.example.questions.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.questions.modal.Question;
import com.example.questions.repository.QuestionRepository;

@Service
public class QuestionService {

	@Autowired
	QuestionRepository questionRepository;
	
	@Autowired
	SequenceGeneratorService sequenceGeneratorService;
	
	public Question getQuestionById(Long id) {
		// TODO Auto-generated method stub
		return questionRepository.findById(id).get();
	}

	public Question createQuestion(Question question) {
		// TODO Auto-generated method stub
		question.setId(sequenceGeneratorService.generateSequence(Question.SEQUENCE_NAME));
		return questionRepository.save(question);
	}
	
	public List<Question> getQuestionsByQuiz(int id) {
		// TODO Auto-generated method stub
		return questionRepository.findByQuiz(id);
	}

}
