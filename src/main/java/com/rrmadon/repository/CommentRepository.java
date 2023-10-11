package com.rrmadon.repository;

import com.rrmadon.entity.Comment;
import com.rrmadon.integration.users.dto.BaseFilter;
import io.quarkus.mongodb.panache.PanacheMongoRepository;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class CommentRepository implements PanacheMongoRepository<Comment> {
	public Optional<Comment> findByCode(String code) {
		return find("code", code).singleResultOptional();
	}

	public List<Comment> findByPostCode(String postCode, BaseFilter baseFilter) {
		return find("postCode", postCode).range(baseFilter.getStartIdx(), baseFilter.getEndIdx()).list();
	}

	public List<Comment> findByParent(String commentCode, BaseFilter baseFilter) {
		return find("commentCode", commentCode).range(baseFilter.getStartIdx(), baseFilter.getEndIdx()).list();
	}
}
