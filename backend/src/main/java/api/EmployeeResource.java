package api;

import models.Employee;
import workload.DTOs.SignUPDTO;
import workload.EmployeeRepository;
import workload.EmployeeService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("employee")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class EmployeeResource {

    @Inject
    EmployeeService service;

    @GET
    public Response getEmployees (){
        return Response
                .ok(service.findAll())
                .build();
    }

    @GET
    @Path("{id}")
    public Response getEmployeeById (@PathParam("id") Long employeeId){
            return Response
                    .ok(service.findById(employeeId))
                    .build();
    }
}
