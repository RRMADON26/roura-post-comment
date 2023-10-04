package com.rrmadon.entity;

import io.quarkus.mongodb.panache.common.MongoEntity;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@MongoEntity(collection = "Posts")
public class Post extends BaseEntity {
	private String title;
	private String body;
	private List<String> tag = new ArrayList<>();

	private List<Comment> comments = new ArrayList<>();

	private int upVote;

	private int downVote;

}
