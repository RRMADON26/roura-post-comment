package com.rrmadon.repository;

import com.rrmadon.entity.Comment;
import io.quarkus.mongodb.panache.PanacheMongoRepository;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class CommentRepository implements PanacheMongoRepository<Comment> {
	public Optional<Comment> findByCode(String code) {
		return find("code", code).singleResultOptional();
	}

	public List<Comment> findByPostCode(String postCode) {
		return find("postCode", postCode).list();
	}

	public List<Comment> findByParent(String commentCode) {
		return find("commentCode", commentCode).list();
	}
}
