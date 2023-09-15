package com.rrmadon.resource;


import com.rrmadon.dto.CommentDTO;
import com.rrmadon.entity.Comment;
import com.rrmadon.service.CommentService;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;

import jakarta.ws.rs.Path;

import java.util.List;

@RequestScoped
@Path("/v1/comments")
public class CommentResource {

	@Inject
	CommentService commentService;

	@POST
	public void addComment(CommentDTO commentDTO) {
		commentService.addComment(commentDTO);
	}

	@GET
	public List<Comment> getAll() {
		return commentService.getAll();
	}

}
