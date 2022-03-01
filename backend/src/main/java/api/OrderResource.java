package api;

import models.OrderET;
import workload.OrderRepository;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;

@Path("order")
public class OrderResource {

    @Inject
    OrderRepository orderRepository;

    @GET
    public Response getOrders(){
        return Response
                .accepted(orderRepository.findAll())
                .build();
    }

    @GET
    @Path("{id}")
    public Response getOrderById(@PathParam("id") Long orderId){
        return Response
                .accepted(orderRepository.findById(orderId))
                .build();
}

    @PUT
    public Response saveOrder(OrderET order){
      return Response
              .accepted(orderRepository.updateET(order))
              .build();
    }

    @DELETE
    @Path("{id}")
    public Response deleteOrderById(@PathParam("id") Long orderId){
        return Response
                .accepted(orderRepository.removeById(orderId))
                .build();
    }

}