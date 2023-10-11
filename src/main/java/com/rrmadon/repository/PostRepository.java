package com.rrmadon.repository;

import com.rrmadon.entity.Post;
import com.rrmadon.integration.users.dto.BaseFilter;
import io.quarkus.mongodb.panache.PanacheMongoRepository;
import io.quarkus.panache.common.Page;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;
import java.util.Optional;

import static com.rrmadon.util.QueryUtil.like;

@ApplicationScoped
public class PostRepository implements PanacheMongoRepository<Post> {
	public Optional<Post> findByCode(String code) {
		return find("code", code).singleResultOptional();
	}

	public List<Post> findByTitle(String title, BaseFilter baseFilter) {
		return find("title like ?1", like(title)).range(baseFilter.getStartIdx(), baseFilter.getEndIdx()).list();
	}
}
