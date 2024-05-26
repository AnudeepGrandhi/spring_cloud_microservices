package io.javabrains.movieinfoservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.javabrains.movieinfoservice.entity.MovieInfoEntity;
import io.javabrains.movieinfoservice.repository.MovieInfoRepository;

@Service
public class MovieInfoService {

	@Autowired
	MovieInfoRepository movieInfoRepository;
	
	public List<MovieInfoEntity> getmovieInfo() {
		
		return movieInfoRepository.findAll();
	}
	
}
