package com.rrmadon.service;

import com.rrmadon.dto.CommentDTO;
import com.rrmadon.entity.Comment;
import com.rrmadon.integration.users.service.UserUtil;
import com.rrmadon.integration.users.service.rest.UserService;
import com.rrmadon.util.CodeUtil;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.NotFoundException;
import lombok.extern.jbosslog.JBossLog;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import java.util.stream.Collectors;

@ApplicationScoped
@JBossLog
public class CommentService extends UserUtil {

	@Inject
	PostService postService;

	@Transactional
	public void addComment(CommentDTO commentDTO) {
		if (commentDTO.getPostCode() != null) {
			postService.findByCode(commentDTO.getPostCode()).ifPresentOrElse(post -> {

				Comment comment = new Comment();
				if (commentDTO.getCommentCode() != null) {

					post.getComments().stream().filter(c -> c.getCode().equals(commentDTO.getCommentCode())).peek(cR -> {
						comment.setCode(CodeUtil.generate());
						comment.setText(commentDTO.getComment());
						comment.setUserCode(comment.getUserCode());
						comment.setCreatedBy(getUser().getCode());

						cR.getComments().add(comment);

						post.update();

					}).collect(Collectors.toUnmodifiableSet());

				} else {
					comment.setCode(CodeUtil.generate());
					comment.setText(commentDTO.getComment());
					comment.setUserCode(comment.getUserCode());
					comment.setCreatedBy(getUser().getCode());

					post.getComments().add(comment);

					post.update();
				}
			}, () -> {
				throw new NotFoundException();
			});
		}
	}

}
