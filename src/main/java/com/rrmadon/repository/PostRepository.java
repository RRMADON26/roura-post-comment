package com.rrmadon.repository;

import com.rrmadon.entity.Post;
import io.quarkus.mongodb.panache.PanacheMongoRepository;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.Optional;

@ApplicationScoped
public class PostRepository implements PanacheMongoRepository<Post> {
	public Optional<Post> findByCode(String code) {
		return find("code", code).singleResultOptional();
	}
}
