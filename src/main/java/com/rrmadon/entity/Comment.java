package com.rrmadon.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.quarkus.mongodb.panache.common.MongoEntity;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@MongoEntity(collection = "comments")
public class Comment extends BaseEntity {
	private String code;

	private String postCode;
	@JsonProperty(index = 1)
	private String text;
	private String userCode;
	private List<Comment> comments = new ArrayList<>();

	private String commentCode;
}
