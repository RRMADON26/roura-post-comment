package com.rrmadon.service;

import com.rrmadon.dto.CommentDTO;
import com.rrmadon.entity.Comment;
import com.rrmadon.integration.users.dto.BaseFilter;
import com.rrmadon.integration.users.service.UserUtil;
import com.rrmadon.repository.CommentRepository;
import com.rrmadon.util.CodeUtil;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.NotFoundException;
import lombok.extern.jbosslog.JBossLog;

import java.util.List;

@ApplicationScoped
@JBossLog
public class CommentService extends UserUtil {

	@Inject
	PostService postService;

	@Inject
	CommentRepository commentRepository;

	@Transactional
	public void addComment(CommentDTO commentDTO) {

		postService.findByCode(commentDTO.getPostCode()).ifPresentOrElse(post -> {

			Comment comment = new Comment();
			if (commentDTO.getCommentCode() != null) {

				commentRepository.findByCode(commentDTO.getCommentCode()).ifPresentOrElse(parent -> {

					comment.setCode(CodeUtil.generate());
					comment.setText(commentDTO.getComment());
					comment.setUserCode(getUser().getCode());
					comment.setCreatedBy(getUser().getCode());
					comment.setPostCode(parent.getPostCode());
					comment.setCommentCode(parent.getCode());

					comment.persist();
				}, () -> {
					throw new NotFoundException();
				});

			} else {

				comment.setCode(CodeUtil.generate());
				comment.setText(commentDTO.getComment());
				comment.setUserCode(getUser().getCode());
				comment.setCreatedBy(getUser().getCode());
				comment.setPostCode(commentDTO.getPostCode());

				comment.persist();
			}
		}, () -> {
			throw new NotFoundException();
		});
	}

	public List<Comment> getComment(String postCode, BaseFilter baseFilter) {
		return commentRepository.findByPostCode(postCode, baseFilter);
	}

	public List<Comment> getChildrenComment(String commentCode, BaseFilter baseFilter) {
		return commentRepository.findByParent(commentCode, baseFilter);
	}
}


