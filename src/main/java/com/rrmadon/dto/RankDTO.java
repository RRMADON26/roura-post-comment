package com.rrmadon.dto;

import io.quarkus.runtime.annotations.RegisterForReflection;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@RegisterForReflection
@AllArgsConstructor
public class RankDTO {
	private String postCode;
	private boolean vote;
}
