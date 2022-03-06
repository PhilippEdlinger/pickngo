package api;

import models.Customer;
import workload.CustomerRepository;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("customer")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CustomerResource {
    @Inject
    private CustomerRepository repo;

    @GET
    public Response getCustomers(){
        return Response.ok(repo.findAll()).build();
    }

    @GET
    @Path("{id}")
    public Response getCustomerById(@PathParam("id") Long id) {
        Customer customer = repo.findById(id);

        return (customer == null ? Response.ok(customer) : Response.status(404)).build();
    }

    @POST
    public Response addCustomer(Customer customer) {
        return Response
                .ok(repo.updateET(customer))
                .build();
    }
}
