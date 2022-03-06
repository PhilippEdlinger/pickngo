package api;

import models.OrderItem;
import workload.OrderPositionRepository;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("category")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class OrderPositionResource {


    @Inject
    OrderPositionRepository orderPositionRepository;

    @GET
    public Response getOrderPosition() {
        return Response.ok(orderPositionRepository.findAll()).build();
    }

    /*@GET
    @Path("{id}")
    public Response getOrderPositionById(@PathParam("id") OrderPositionID orderPositionId){
        if (orderPositionId != null){
            return Response
                    .ok(orderPositionRepository.findById(orderPositionId))
                    .build();
        }else {
            return Response
                    .ok(orderPositionRepository.findAll())
                    .build();
        }

    }*/

    @PUT
    public Response createOrderPosition(OrderItem orderItem){
        return Response
                .ok(orderPositionRepository.updateET(orderItem))
                .build();
    }

    /*
    @DELETE
    @Path("{id}")
    public Response deleteOrderPositionById(@PathParam("id") OrderPositionID orderPositionID ){
        return Response.ok(orderPositionRepository.deleteById(orderPositionID)).build();
    }
*/

}
