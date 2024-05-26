package io.javabrains.movieinfoservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.javabrains.movieinfoservice.entity.MovieInfoEntity;
import io.javabrains.movieinfoservice.service.MovieInfoService;

@RestController
public class MovieInfoController {

	@Autowired
	MovieInfoService movieInfoService;
	
	@RequestMapping("/movieInfo")
	public List<MovieInfoEntity> getmovieInfo() {
		
		return movieInfoService.getmovieInfo();
	}
	
}
