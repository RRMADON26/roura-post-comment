package com.rrmadon.integration.users.dto;

import jakarta.ws.rs.DefaultValue;
import jakarta.ws.rs.QueryParam;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class BaseFilter {

	@QueryParam("startIdx")
	@DefaultValue("0")
	private int startIdx;

	@QueryParam("endIdx")
	@DefaultValue("10")
	private int endIdx;

	@QueryParam("trending")
	private boolean trending;
}
