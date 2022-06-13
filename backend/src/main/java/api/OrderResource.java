package api;

import io.quarkus.mailer.Mail;
import io.quarkus.mailer.Mailer;
import models.OrderET;
import workload.OrderService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("order")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
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
<<<<<<< HEAD
        String emailFooter = "\n Vielen Dank, dass Sie beim Cagitzer x Pick'n'Go bestellt haben! \n";
=======
        String emailHeader = "\n Vielen Dank, dass Sie beim Cagitzer x Pick'n'Go bestellt haben! \n \n Ihre Bestellung: \n";
        String emailFooter = "\n Cagitzer x Pick'n'Go! \n  Adresse: Mühlbachstraße 91, 4063 Hörsching \n Telefon: 07221 72294 \n";
>>>>>>> acc707d8510eec3904d1ea81592cb75191712ba8

        for (var o : orderET.orderItems) {
            var p = o.orderItemID.getProduct();
            emailText += " |"  p.getName() + "|  -  |" + p.getPreparationTime() + "|  -  |" + p.getPrice() + + "| " "\n";
        }

        mailer.send(
                Mail.withText("dp.precup@gmail.com",
                        "Ihre Bestellungsbestätigung von Pick'n'Go",
                        emailHeader + emailText + emailFooter
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
