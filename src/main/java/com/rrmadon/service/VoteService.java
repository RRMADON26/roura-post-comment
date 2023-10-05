package com.rrmadon.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.NotFoundException;

@ApplicationScoped
public class VoteService {

	@Inject
	PostService postService;

	@Transactional
	public void upvote(String postCode) {

		postService.findByCode(postCode).ifPresentOrElse(post -> {
			post.setUpVote(post.getUpVote() + 1);

			post.update();

		}, () -> {
			throw new NotFoundException();
		});

	}

	@Transactional
	public void downvote(String postCode) {
		postService.findByCode(postCode).ifPresentOrElse(post -> {
			post.setDownVote(post.getDownVote() + 1);

			post.update();

		}, () -> {
			throw new NotFoundException();
		});
	}
}
