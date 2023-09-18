package com.rrmadon.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommentDTO {
	private String userCode;
	private String comment;
	private String commentCode;

	private String postCode;
}
