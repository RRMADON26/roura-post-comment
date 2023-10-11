package com.rrmadon.resource;


import com.rrmadon.dto.CommentDTO;
import com.rrmadon.entity.Comment;
import com.rrmadon.integration.users.dto.BaseFilter;
import com.rrmadon.service.CommentService;
import jakarta.annotation.security.RolesAllowed;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.BeanParam;
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
	public List<Comment> getComments(@QueryParam("postCode") String postCode, @BeanParam BaseFilter baseFilter) {
		return commentService.getComment(postCode, baseFilter);
	}

	@GET
	@RolesAllowed("CUSTOMER")
	@Path("/child")
	public List<Comment> getChildrenComments(@QueryParam("commentCode") String commentCode, @BeanParam BaseFilter baseFilter) {
		return commentService.getChildrenComment(commentCode, baseFilter);
	}


}
