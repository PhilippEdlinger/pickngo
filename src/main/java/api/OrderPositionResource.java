package api;

import models.Category;
import models.OrderPosition;
import models.OrderPositionID;
import workload.CategoryRepository;
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
        return Response.accepted(orderPositionRepository.findAll()).build();
    }

    @GET
    @Path("{id}")
    public Response getOrderPositionById(@PathParam("id") OrderPositionID orderPositionId){
        if (orderPositionId != null){
            return Response
                    .accepted(orderPositionRepository.findById(orderPositionId))
                    .build();
        }else {
            return Response
                    .accepted(orderPositionRepository.findAll())
                    .build();
        }

    }

    @PUT
    public Response createOrderPosition(OrderPosition orderPosition){
        return Response
                .accepted(orderPositionRepository.updateET(orderPosition))
                .build();
    }

    @DELETE
    @Path("{id}")
    public Response deleteOrderPositionById(@PathParam("id") OrderPositionID orderPositionID ){
        return Response.accepted(orderPositionRepository.deleteById(orderPositionID)).build();
    }


}
