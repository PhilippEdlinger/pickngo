package api;

import io.quarkus.mailer.Mail;
import io.quarkus.mailer.Mailer;
import models.OrderET;
import workload.OrderService;
import workload.ProductService;

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
    private ProductService productService;
    @Inject
    Mailer mailer;

    @GET
    public Response getOrders() {
        return Response
                .ok(service.findAll())
                .build();
    }

    @GET
    @Path("{id}/{orderPosition}")
    public Response getOrderById(@PathParam("id") Long orderId, @PathParam("orderPosition") Long orderPosition) {
        return Response
                .ok(service.findById(orderId))
                .build();
    }

    @POST
    public Response saveOrder(OrderET order) {
        var orderET = service.persistET(order);

        String emailAdress = orderET.getCustomer().getEmail();
        String emailText = "";
        String emailHeader = "\n Vielen Dank, dass Sie beim Cagitzer x Pick'n'Go bestellt haben! \n \n Ihre Bestellung lautet: \n";
        String emailFooter = "\n Cagitzer x Pick'n'Go! \n Adresse: Mühlbachstraße 91, 4063 Hörsching \n Telefon: 07221 72294 \n";
        String emailTime = "Sie können Ihre bestellung um xxx"  +  " Uhr abhohlen!"

        for (var o : order.getOrderItems()) {
            var p = productService.findById(o.orderItemID.getProduct().id);
            emailText += " " + p.getName() + p.getProduct +": " + p.getPrice() + " € " + "\n";

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
    public Response deleteOrderById(@PathParam("id") Long orderId, @PathParam("orderPosition") Long orderPosition) {
        return Response
                .ok(service.removeById(orderId))
                .build();
    }

}
