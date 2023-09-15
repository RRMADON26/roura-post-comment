package com.rrmadon.util;

import org.apache.commons.lang3.RandomStringUtils;

import java.io.Serializable;

public class CodeUtil implements Serializable {

	public static String generate() {
		return RandomStringUtils.randomAlphanumeric(10).toUpperCase();
	}
}
