package com.rrmadon.repository;

import com.rrmadon.entity.Post;
import com.rrmadon.integration.users.dto.BaseFilter;
import io.quarkus.mongodb.panache.PanacheMongoRepository;
import io.quarkus.panache.common.Sort;
import jakarta.enterprise.context.ApplicationScoped;

import java.time.LocalDateTime;
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

	public List<Post> getTrending() {
		return find("createdAt >= ?1 and createdAt <= ?2",
				Sort.by("popularity").descending(), LocalDateTime.now().minusDays(1), LocalDateTime.now().plusDays(1)).list();
	}
}
