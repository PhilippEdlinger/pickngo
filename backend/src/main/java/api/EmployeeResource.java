package api;

import models.Employee;
import workload.EmployeeRepository;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;

@Path("employee")
public class EmployeeResource {

    @Inject
    EmployeeRepository employeeRepository;

    @GET
    public Response getEmployees (){
        return Response
                .accepted(employeeRepository.findAll())
                .build();
    }

    @GET
    @Path("{id}")
    public Response getEmployeeById (@PathParam("id") Long employeeId){
            return Response
                    .accepted(employeeRepository.findById(employeeId))
                    .build();
    }

    @PUT
    public Response saveEmployee (Employee employee){
        return Response
                .accepted(employeeRepository.updateET(employee))
                .build();
    }

    @DELETE
    @Path("{id}")
    public Response deleteEmployeeById(@PathParam("id") Long employeeId){
        return Response
                .accepted(employeeRepository.removeById(employeeId))
                .build();
    }

}
