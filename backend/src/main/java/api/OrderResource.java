package api;

import io.quarkus.mailer.Mail;
import io.quarkus.mailer.Mailer;
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
    @Inject
    Mailer mailer;

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
        var orderET = service.persistET(order);
        String emailText = "";

        for (var o : orderET.orderItems) {
            emailText += """
                   
                    """;
        }

        mailer.send(
                Mail.withText("dp.precup@gmail.com",
                        "Ahoy from Quarkus",
                        "A simple email sent from a Quarkus application."
                )
        );

        return Response
                .ok(orderET)
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
