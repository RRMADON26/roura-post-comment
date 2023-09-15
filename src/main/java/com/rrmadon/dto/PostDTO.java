package com.rrmadon.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PostDTO {

	private String title;
	private String body;
	private List<String> tag;

}
