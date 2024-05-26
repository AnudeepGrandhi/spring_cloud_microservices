package com.in28minutes.rest.webservices.restwebservices.user;

import com.in28minutes.rest.webservices.restwebservices.post.Post;
import com.in28minutes.rest.webservices.restwebservices.post.PostNotFoundException;
import com.in28minutes.rest.webservices.restwebservices.post.PostRepository;
import jakarta.validation.Valid;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
public class UserJpaResource {

	private UserRepository userRepository;
	private PostRepository postRepository;

	public UserJpaResource(UserRepository userRepository, PostRepository postRepository) {
		this.userRepository = userRepository;
		this.postRepository = postRepository;
	}
	
	///Get All Users
	@GetMapping("/jpa/users")
	public List<User> retrieveAllUser() {
		return userRepository.findAll();
	}
	
	///Get specific User
	///HATEOAS - http://localhost:8080/users
	
	@GetMapping("/jpa/users/{userId}")
	public EntityModel<User> retrieveUser(@PathVariable Integer userId) {
		Optional<User> user = userRepository.findById(userId);
		
		if(user.isEmpty()) {
			throw new UserNotFoundException("Id: "+userId);
		}
		
		///EntityModel - We wrap bean in EntityModel to append url links to each bean without changing bean structure.
		EntityModel<User> entityModel = EntityModel.of(user.get());
		
		///WebMVCLinkBuilder - To create links based on the method 
		WebMvcLinkBuilder link = linkTo(methodOn(this.getClass()).retrieveAllUser());
		entityModel.add(link.withRel("all-users"));
		
		return entityModel;
	}
	
	///Delete specific User
	@DeleteMapping("/jpa/users/{userId}")
	public void removeUser(@PathVariable Integer userId) {
		userRepository.deleteById(userId);
	}
	
	///Create New User
	@PostMapping("/jpa/users")
	public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
		User savedUser = userRepository.save(user);
		
		// /users/4 => /users , /{id} => savedUser.getId()
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()  ///returns current request path ("/users")
				.path("/{id}")
				.buildAndExpand(savedUser.getId()) /////Replaces "/{id}" with created user id.
				.toUri(); ///converts to location of the new resource(uri)
		
		///Always return appropriate response status and the location(uri of the resource) based on the action performed.
		return ResponseEntity.created(location).build();
	}

	///Get all posts of a Specific user.
	@GetMapping("/jpa/users/{userId}/posts")
	public List<Post> retrievePostsOfUser(@PathVariable Integer userId) {
		Optional<User> user = userRepository.findById(userId);

		if(user.isEmpty()) {
			throw new UserNotFoundException("Id: "+userId);
		}

		return user.get().getPosts();
	}

	////Create Post for a user
	@PostMapping("/jpa/users/{userId}/posts")
	public ResponseEntity<User> createUser(@PathVariable int userId, @Valid @RequestBody Post post) {
		Optional<User> user = userRepository.findById(userId);

		if(user.isEmpty()) {
			throw new UserNotFoundException("Id: "+userId);
		}

		post.setUser(user.get());
		Post savedPost = postRepository.save(post);

		// /posts/4 => /posts , /{id} => savedUser.getId()
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()  ///returns current request path ("/posts")
				.path("/{id}")
				.buildAndExpand(savedPost.getId()) /////Replaces "/{id}" with created user id.
				.toUri(); ///converts to location of the new resource(uri)

		///Always return appropriate response status and the location(uri of the resource) based on the action performed.
		return ResponseEntity.created(location).build();
	}

	@GetMapping("/jpa/users/{userId}/posts/{postId}")
	public EntityModel<Post> retrievePost(@PathVariable Integer userId, @PathVariable Integer postId) {
		Optional<User> user = userRepository.findById(userId);

		if(user.isEmpty()) {
			throw new UserNotFoundException("Id: "+userId);
		}

		Optional<Post> post = postRepository.findById(postId);

		if(post.isEmpty()) {
			throw new PostNotFoundException("Id: "+postId);
		}

		///EntityModel - We wrap bean in EntityModel to append url links to each bean without changing bean structure.
		EntityModel<Post> entityModel = EntityModel.of(post.get());

		///WebMVCLinkBuilder - To create links based on the method
		WebMvcLinkBuilder link = linkTo(methodOn(this.getClass()).retrievePostsOfUser(userId));
		entityModel.add(link.withRel("all-posts"));

		return entityModel;
	}
	
}
