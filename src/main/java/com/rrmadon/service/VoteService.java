package com.rrmadon.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rrmadon.dto.RankDTO;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.NotFoundException;
import lombok.extern.jbosslog.JBossLog;
import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.eclipse.microprofile.reactive.messaging.Message;

import java.io.IOException;
import java.util.concurrent.CompletionStage;

@JBossLog
@ApplicationScoped
public class VoteService {

	@Inject
	PostService postService;

	@Inject
	ObjectMapper objectMapper;

	@Transactional
	@Incoming("vote")
	public CompletionStage<Void> vote(Message<String> request) throws IOException {

		RankDTO rankDTO = objectMapper.readValue(request.getPayload(), RankDTO.class);

		log.info(objectMapper.writeValueAsString(rankDTO));

		postService.getByCode(rankDTO.getPostCode()).ifPresentOrElse(post -> {
			if (rankDTO.isVote()) {
				post.setUpVote(post.getUpVote() + 1);

				if (post.getDownVote() > 0) {
					post.setDownVote(post.getDownVote() - 1);
				}
			} else {
				post.setDownVote(post.getDownVote() + 1);

				if (post.getUpVote() > 0) {
					post.setUpVote(post.getUpVote() - 1);
				}
			}

			post.setPopularity(post.getUpVote() - post.getDownVote());

			post.update();

		}, () -> request.nack(new NotFoundException()));

		return request.ack();

	}

}
