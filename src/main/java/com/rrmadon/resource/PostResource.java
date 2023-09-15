package com.rrmadon.resource;

import com.rrmadon.dto.PostDTO;
import com.rrmadon.entity.Post;
import com.rrmadon.service.PostService;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;

import java.util.List;

@RequestScoped
@Path("/v1/posts")
public class PostResource {

	@Inject
	PostService postService;

	@POST
	public PostDTO createPost(PostDTO postDTO) {
		return postService.createPost(postDTO);
	}

	@GET
	public List<Post> getPosts() {
		return postService.getPosts();
	}
}
