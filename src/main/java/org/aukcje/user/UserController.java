package org.aukcje.user;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.net.URI;
import java.util.List;

@Path("/user")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UserController {

    @Inject
    private UserService userService;

    @GET
    public List<User> getAllUsers() {
        return userService.getAll();
    }

    @GET
    @Path("/{id}")
    public User getUserById(@PathParam("id") Long id) {
        return userService.findById(id);
    }

    @POST
    @Transactional
    public Response saveUser(User user) {
        if(!userService.emailAlreadyExists(user.getEmail())) {
            userService.saveUser(user);
            return Response.created(URI.create("/user/" + user.id)).build();
        }
        return Response.status(Response.Status.BAD_REQUEST).build();
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    public void deleteById(@PathParam("id") Long id) {
        userService.deleteById(id);
    }
}
