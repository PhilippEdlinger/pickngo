package api;

import models.Employee;
import workload.EmployeeRepository;
import workload.EmployeeService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;

@Path("employee")
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

    @PUT
    public Response saveEmployee (Employee employee){
        return Response
                .ok(service.updateET(employee))
                .build();
    }
}
