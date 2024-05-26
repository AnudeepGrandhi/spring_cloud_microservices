package io.javabrains.movieinfoservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.javabrains.movieinfoservice.entity.MovieInfoEntity;

@Repository
public interface MovieInfoRepository extends JpaRepository<MovieInfoEntity, String>{

}
