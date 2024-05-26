package com.in28minutes.rest.webservices.restwebservices.post;

import com.in28minutes.rest.webservices.restwebservices.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Integer> {
}
