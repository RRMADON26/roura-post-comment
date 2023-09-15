package com.rrmadon.repository;

import com.rrmadon.entity.Comment;
import io.quarkus.mongodb.panache.PanacheMongoRepository;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;

@ApplicationScoped
public class CommentRepository implements PanacheMongoRepository<Comment> {
	public List<Comment> findCommentByCode(String code) {
		return find("comments.code" , code ).list();
	}
}
