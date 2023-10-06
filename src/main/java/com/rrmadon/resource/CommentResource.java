package com.rrmadon.resource;


import com.rrmadon.dto.CommentDTO;
import com.rrmadon.entity.Comment;
import com.rrmadon.service.CommentService;
import jakarta.annotation.security.RolesAllowed;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.QueryParam;

import java.util.List;

@RequestScoped
@Path("/v1/comments")
public class CommentResource {

	@Inject
	CommentService commentService;

	@POST
	@RolesAllowed("CUSTOMER")
	public void addComment(CommentDTO commentDTO) {
		commentService.addComment(commentDTO);
	}

	@GET
	@RolesAllowed("CUSTOMER")
	public List<Comment> getComments(@QueryParam("postCode") String postCode) {
		return commentService.getComment(postCode);
	}

	@GET
	@Path("/child")
	public List<Comment> getChildrenComments(@QueryParam("commentCode") String commentCode) {
		return commentService.getChildrenComment(commentCode);
	}


}
