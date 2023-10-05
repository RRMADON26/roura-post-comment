package com.rrmadon.resource;


import com.rrmadon.service.VoteService;
import jakarta.annotation.security.RolesAllowed;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.QueryParam;

@RequestScoped
@Path("/v1/votes")
@RolesAllowed("CUSTOMER")
public class VoteResource {

	@Inject
	VoteService voteService;

	@POST
	@Path("/up")
	public void upvote(@QueryParam("postCode") String postCode) {
		voteService.upvote(postCode);
	}

	@POST
	@Path("/down")
	public void downvote(@QueryParam("postCode") String postCode) {
		voteService.downvote(postCode);
	}
}
