package com.rrmadon.service;

import com.rrmadon.dto.CommentDTO;
import com.rrmadon.entity.Comment;
import com.rrmadon.repository.CommentRepository;
import com.rrmadon.util.CodeUtil;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.util.List;

@ApplicationScoped
public class CommentService {

	@Inject
	PostService postService;

	@Inject
	CommentRepository commentRepository;

	@Transactional
	public void addComment(CommentDTO commentDTO) {
		if (commentDTO.getPostCode() != null) {
			postService.findByCode(commentDTO.getPostCode()).ifPresent(post -> {
				Comment comment = new Comment();

				comment.setCode(CodeUtil.generate());
				comment.setText(commentDTO.getComment());
				comment.setUserCode(comment.getUserCode());

				post.getComments().add(comment);

				post.update();
			});
		}
	}

	public List<Comment> getAll() {
		return commentRepository.findCommentByCode("QLD7I2890V");
	}


}
