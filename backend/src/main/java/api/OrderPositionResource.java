package api;

import models.*;
import workload.OrderPositionRepository;
import workload.OrderRepository;
import workload.ProductRepository;

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

    @Inject
    OrderRepository orderRepository;

    @Inject
    ProductRepository productRepository;

    @GET
    public Response getOrderPosition() {
        return Response.accepted(orderPositionRepository.findAll()).build();
    }

    @GET
    @Path("{orderId}/{productId}")
    public Response getOrderPositionById(@PathParam("orderId")Long orderId, @PathParam("productId")Long productId ) {

        OrderET order = orderRepository.findById(orderId);
        Product product = productRepository.findById(productId);

        return Response.accepted(orderPositionRepository.getOrderPosition(order, product)).build();

        /*
        if (orderPositionId != null){
            return Response
                    .accepted(orderPositionRepository.findById(orderPositionId))
                    .build();
        }else {
            return Response
                    .accepted(orderPositionRepository.findAll())
                    .build();
        }*/

    }

    @PUT
    public Response createOrderPosition(OrderPosition orderPosition){
        return Response
                .accepted(orderPositionRepository.updateET(orderPosition))
                .build();
    }

    /*
    @DELETE
    @Path("{id}")
    public Response deleteOrderPositionById(@PathParam("id") OrderPositionID orderPositionID ){
        return Response.accepted(orderPositionRepository.deleteById(orderPositionID)).build();
    }
    */

}
