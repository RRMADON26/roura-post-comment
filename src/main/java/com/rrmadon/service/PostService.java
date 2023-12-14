package com.rrmadon.service;

import com.rrmadon.dto.PostDTO;
import com.rrmadon.entity.Post;
import com.rrmadon.integration.users.dto.BaseFilter;
import com.rrmadon.integration.users.service.UserUtil;
import com.rrmadon.repository.PostRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class PostService extends UserUtil {

	@Inject
	PostRepository postRepository;

	@Transactional
	public PostDTO createPost(PostDTO postDTO) {

		Post post = new Post();

		post.setTitle(postDTO.getTitle());
		post.setBody(postDTO.getBody());
		post.setTag(postDTO.getTag());
		post.setCreatedBy(getUser().getCode());

		post.persist();

		return postDTO;

	}

	public List<Post> getPosts(String title, BaseFilter baseFilter) {
		if (baseFilter.isTrending()) {
			return postRepository.getTrending();
		}

		return postRepository.findByTitle(title, baseFilter);
	}

	public Optional<Post> getByCode(String code) {
		return postRepository.findByCode(code);
	}
}
