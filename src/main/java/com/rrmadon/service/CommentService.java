package com.rrmadon.service;

import com.rrmadon.dto.CommentDTO;
import com.rrmadon.entity.Comment;
import com.rrmadon.util.CodeUtil;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import lombok.extern.jbosslog.JBossLog;

import java.util.stream.Collectors;

@ApplicationScoped
@JBossLog
public class CommentService {

	@Inject
	PostService postService;

	@Transactional
	public void addComment(CommentDTO commentDTO) {
		if (commentDTO.getPostCode() != null) {
			postService.findByCode(commentDTO.getPostCode()).ifPresent(post -> {

				Comment comment = new Comment();
				if (commentDTO.getCommentCode() != null) {

					post.getComments().stream().filter(c -> c.getCode().equals(commentDTO.getCommentCode())).map(cR -> {
						comment.setCode(CodeUtil.generate());
						comment.setText(commentDTO.getComment());
						comment.setUserCode(comment.getUserCode());

						cR.getComments().add(comment);

						post.update();

						return cR;
					}).collect(Collectors.toUnmodifiableSet());


				} else {
					comment.setCode(CodeUtil.generate());
					comment.setText(commentDTO.getComment());
					comment.setUserCode(comment.getUserCode());

					post.getComments().add(comment);

					post.update();
				}
			});
		}
	}


}
