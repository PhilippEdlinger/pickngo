package api;

import models.Customer;
import workload.CustomerService;
import workload.DTOs.SignUPDTO;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("customer")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CustomerResource {
    @Inject
    private CustomerService service;

    @GET
    public Response getCustomers(){
        System.out.println(service.findAll());
        return Response.ok(service.findAll()).build();
    }

    @GET
    @Path("{id}")
    public Response getCustomerById(@PathParam("id") Long id) {
        Customer customer = service.findById(id);
        return (customer != null ? Response.ok(customer) : Response.status(404)).build();
    }

    @POST
    @Path("signUp")
    public Response signUP(Customer customer) {
        SignUPDTO signUPDTO = service.signUP(customer);
        return Response.ok(signUPDTO).build();
    }

    @POST
    @Path("signIn/{username}/{password}")
    public Response signIn(@PathParam("username") String username, @PathParam("password") String password) {
        SignUPDTO signInDTO = service.signIn(username, password);
        return Response.ok(signInDTO).build();
    }
}
