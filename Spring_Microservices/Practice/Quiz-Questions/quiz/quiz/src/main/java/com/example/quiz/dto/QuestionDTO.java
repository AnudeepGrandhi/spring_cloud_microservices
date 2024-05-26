package com.example.quiz.dto;

public class QuestionDTO {
	
	private Long id;
	private String name;
	private String options;
	private Integer correct_option;
	private int quiz;
	private Integer points;
	
	public QuestionDTO(Long id, String name, String options, Integer correct_option, int quiz, Integer points) {
		super();
		this.id = id;
		this.name = name;
		this.options = options;
		this.correct_option = correct_option;
		this.quiz = quiz;
		this.points = points;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getOptions() {
		return options;
	}
	public void setOptions(String options) {
		this.options = options;
	}
	public Integer getCorrect_option() {
		return correct_option;
	}
	public void setCorrect_option(Integer correct_option) {
		this.correct_option = correct_option;
	}
	public int getQuiz() {
		return quiz;
	}
	public void setQuiz(int quiz) {
		this.quiz = quiz;
	}
	public Integer getPoints() {
		return points;
	}
	public void setPoints(Integer points) {
		this.points = points;
	}
	
	
	
}
