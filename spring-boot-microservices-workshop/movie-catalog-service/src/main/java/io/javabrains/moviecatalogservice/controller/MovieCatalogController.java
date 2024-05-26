package io.javabrains.moviecatalogservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.javabrains.moviecatalogservice.entity.MovieEntity;
import io.javabrains.moviecatalogservice.service.MovieCatalogService;

@RestController
public class MovieCatalogController {
	
	@Autowired
	MovieCatalogService movieService;
	
	@RequestMapping("/movies")
	public List<MovieEntity> getMovieCatalog() {
		return movieService.getMovieCatalog();
	}
	
	@RequestMapping("/highestRating")
	public List<MovieEntity> getNthHighestRating(@RequestParam("n") int n) {
		return movieService.getNthHighestRating(n-1);
	}

}
