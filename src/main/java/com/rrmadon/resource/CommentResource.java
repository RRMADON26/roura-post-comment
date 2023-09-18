package com.rrmadon.resource;


import com.rrmadon.dto.CommentDTO;
import com.rrmadon.service.CommentService;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;

@RequestScoped
@Path("/v1/comments")
public class CommentResource {

	@Inject
	CommentService commentService;

	@POST
	public void addComment(CommentDTO commentDTO) {
		commentService.addComment(commentDTO);
	}

}
