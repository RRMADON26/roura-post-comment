package com.rrmadon.entity;

import com.rrmadon.util.CodeUtil;
import io.quarkus.mongodb.panache.PanacheMongoEntity;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class BaseEntity extends PanacheMongoEntity {
	private LocalDate createdAt = LocalDate.now();
	private LocalDate updatedAt = LocalDate.now();
	private String createdBy = "0";
	private String updatedBy = "0";
	private String code = CodeUtil.generate();
}
