package com.rrmadon.util;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.eclipse.microprofile.jwt.JsonWebToken;

@ApplicationScoped
public class AuthenticationUtil {

	@Inject
	JsonWebToken jsonWebToken;

	public JsonWebToken getAuth() {
		return jsonWebToken;
	}

}
