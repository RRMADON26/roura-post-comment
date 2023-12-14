package com.rrmadon.entity;

import com.rrmadon.util.CodeUtil;
import io.quarkus.mongodb.panache.PanacheMongoEntity;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class BaseEntity extends PanacheMongoEntity {
	private LocalDateTime createdAt = LocalDateTime.now();
	private LocalDateTime updatedAt = LocalDateTime.now();
	private String createdBy = "0";
	private String updatedBy = "0";
	private String code = CodeUtil.generate();
}
