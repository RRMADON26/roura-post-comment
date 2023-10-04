package com.rrmadon.integration.users.service;

import com.rrmadon.integration.users.service.rest.UserService;
import com.rrmadon.integration.users.dto.UserDTO;
import com.rrmadon.util.AuthenticationUtil;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.eclipse.microprofile.rest.client.inject.RestClient;

@ApplicationScoped
public class UserUtil extends AuthenticationUtil {

	@Inject
	@RestClient
	UserService userService;

	public UserDTO getUser() {
		return userService.getUser("Bearer " + getAuth().getRawToken());
	}

}
