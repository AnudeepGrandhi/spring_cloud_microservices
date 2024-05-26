package io.javabrains.moviecatalogservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import io.javabrains.moviecatalogservice.entity.MovieEntity;

public interface MovieCatalogRepository extends JpaRepository<MovieEntity, String>{
	
	@Query(nativeQuery = true, value = "select * from movie_details where rating = (select distinct rating from movie_details order by rating desc limit :n, 1)")
	List<MovieEntity> getNthHighestRating(@Param("n") int n);
	
}
