package com.rrmadon.resource;

import com.rrmadon.dto.PostDTO;
import com.rrmadon.entity.Post;
import com.rrmadon.integration.users.dto.BaseFilter;
import com.rrmadon.service.PostService;
import jakarta.annotation.security.RolesAllowed;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.BeanParam;
import jakarta.ws.rs.DefaultValue;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.QueryParam;

import java.util.List;

@RequestScoped
@Path("/v1/posts")
public class PostResource {

	@Inject
	PostService postService;

	@POST
	@RolesAllowed("CUSTOMER")
	public PostDTO createPost(PostDTO postDTO) {
		return postService.createPost(postDTO);
	}

	@GET
	@RolesAllowed("CUSTOMER")
	public List<Post> getPosts(@QueryParam("title") @DefaultValue("") String title, @BeanParam BaseFilter baseFilter) {
		return postService.getPosts(title, baseFilter);
	}
}
