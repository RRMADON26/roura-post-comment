package com.rrmadon.integration.users.service.rest;


import com.rrmadon.integration.users.dto.UserDTO;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.HeaderParam;
import jakarta.ws.rs.Path;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@Path("/users")
@RegisterRestClient(configKey = "user-api")
public interface UserService {

	@GET
	UserDTO getUser(@HeaderParam("Authorization") String auth);

}
