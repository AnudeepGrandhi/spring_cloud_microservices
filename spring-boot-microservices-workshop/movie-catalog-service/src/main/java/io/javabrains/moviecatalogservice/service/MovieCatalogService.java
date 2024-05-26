package io.javabrains.moviecatalogservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.javabrains.moviecatalogservice.entity.MovieEntity;
import io.javabrains.moviecatalogservice.repository.MovieCatalogRepository;

@Service
public class MovieCatalogService {
	
	@Autowired
	MovieCatalogRepository movieRepository;

	public List<MovieEntity> getMovieCatalog() {
		return movieRepository.findAll();
	}
	
	public List<MovieEntity> getNthHighestRating(int n) {
		return movieRepository.getNthHighestRating(n);
	}
}
