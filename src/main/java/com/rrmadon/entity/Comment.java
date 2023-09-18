package com.rrmadon.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.quarkus.mongodb.panache.common.MongoEntity;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@MongoEntity(collection = "Posts")
public class Comment extends BaseEntity {
	private String code;

	@JsonProperty(index = 1)
	private String text;
	private String userCode;
	private List<Comment> comments = new ArrayList<>();
}
