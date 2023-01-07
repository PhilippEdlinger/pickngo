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
import java.time.format.DateTimeFormatter;
import java.util.concurrent.atomic.AtomicReference;

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

    @GET
    @Path("allNotClosed")
    public Response getAllNotClosed() {
        return Response.ok(service.getAllOpenOrders()).build();
    }

    @PUT
    @Path("close/{id}")
    public Response closeOrder(@PathParam("id") Long id) {
        service.close(id);
        return Response.ok().build();
    }

    @POST
    public Response saveOrder(OrderET order) {
        var orderET = service.persistET(order);
        System.out.println("-----");
        System.out.println( order.customer);
        System.out.println(order.getId());

        Long duration = 0L;
        for (var oi : order.getOrderItems()) {
            duration += oi.orderItemId.getProduct().getPreparationTime();
        }

        if (orderET.getCustomer() != null) {
            String emailAdress = orderET.getCustomer().getEmail();
            String emailText = "";
            String emailHeader = "\n Vielen Dank, dass Sie beim Cagitzer x Pick'n'Go bestellt haben! \n \n Ihre Bestellung lautet: \n";
            String emailTime = "\n Ihre Bestellung ist in " + duration + " Minuten abholbereit! \n \n";
            String emailFooter = "\n Cagitzer x Pick'n'Go! \n Adresse: Mühlbachstraße 91, 4063 Hörsching \n Telefon: 07221 72294 \n";


            for (var o : order.getOrderItems()) {
                var p = productService.findById(o.orderItemId.getProduct().id);
                emailText += o.getQuantity()  + "x " + p.getName() + ": " + p.getPrice() + "0 € " + "\n";

            }

            System.out.println(orderET.getId());
            System.out.println(orderET.getCustomer().getEmail());
            System.out.println(orderET.getCustomer().id);

            mailer.send(
                    Mail.withText(emailAdress,
                            "Ihre Bestellungsbestätigung von Pick'n'Go",
                            emailHeader + emailText + emailTime + emailFooter
                    )
            );
        }

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
