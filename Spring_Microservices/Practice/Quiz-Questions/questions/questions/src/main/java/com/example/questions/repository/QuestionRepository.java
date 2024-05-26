package com.example.questions.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.questions.modal.Question;

@Repository
public interface QuestionRepository extends MongoRepository<Question, Long>{

	public List<Question> findByQuiz(int id);
	
}
