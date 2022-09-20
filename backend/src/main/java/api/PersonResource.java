package api;

import workload.DTOs.SignUPDTO;
import workload.PersonService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("person")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PersonResource {
    @Inject
    private PersonService service;

    @POST
    @Path("signIn/{username}/{password}")
    public Response signIn(@PathParam("username") String username, @PathParam("password") String password) {
        SignUPDTO signInDTO = service.signIn(username, password);
        return Response.ok(signInDTO).build();
    }
}
