package api;

import models.OrderET;
import workload.OrderRepository;
import workload.OrderService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;

@Path("order")
public class OrderResource {

    @Inject
    private OrderService service;

    @GET
    public Response getOrders(){
        return Response
                .ok(service.findAll())
                .build();
    }

    @GET
    @Path("{id}/{orderPosition}")
    public Response getOrderById(@PathParam("id") Long orderId, @PathParam("orderPosition") Long orderPosition){
        return Response
                .ok(service.findById(orderId, orderPosition))
                .build();
}

    @POST
    public Response saveOrder(OrderET order){
      return Response
              .ok(service.persistET(order))
              .build();
    }

    @DELETE
    @Path("{id}/{orderPosition}")
    public Response deleteOrderById(@PathParam("id") Long orderId, @PathParam("orderPosition") Long orderPosition){
        return Response
                .ok(service.removeById(orderId, orderPosition))
                .build();
    }

}
