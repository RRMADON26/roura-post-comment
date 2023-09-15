package com.rrmadon.entity;

import io.quarkus.mongodb.panache.common.MongoEntity;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@MongoEntity(collection = "Posts", )
public class Comment extends BaseEntity {
	private String code;
	private String text;
	private String userCode;
	private List<Comment> nestedComment = new ArrayList<>();
	private List<Comment> comments = new ArrayList<>();
}
