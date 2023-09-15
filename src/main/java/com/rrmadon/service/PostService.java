package com.rrmadon.service;

import com.rrmadon.dto.PostDTO;
import com.rrmadon.entity.Comment;
import com.rrmadon.entity.Post;
import com.rrmadon.repository.PostRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.jboss.logging.annotations.Pos;

import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class PostService {

	@Inject
	PostRepository postRepository;

	@Transactional
	public PostDTO createPost(PostDTO postDTO) {

		Post post = new Post();

		post.setTitle(postDTO.getTitle());
		post.setBody(postDTO.getBody());
		post.setTag(postDTO.getTag());


		post.persist();

		return postDTO;

	}

	public List<Post> getPosts() {
		return postRepository.listAll();
	}

	public Optional<Post> findByCode(String code) {
		return postRepository.findByCode(code);
	}

	public Optional<Post> findByCommentCode(String code) {
		return postRepository.findByCommentCode(code);
	}
}
