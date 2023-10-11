package com.rrmadon.util;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class QueryUtil {

	/**
	 * https://www.mongodb.com/docs/manual/reference/operator/query/regex/#perform-case-insensitive-regular-expression-match
	 * @param value
	 * @return
	 */
	public static String like(String value) {
		return "/" + value + "/i";
	}
}
