package api;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import io.quarkus.mailer.Mail;
import io.quarkus.mailer.Mailer;
import models.OrderET;
import workload.OrderService;
import workload.ProductService;

import javax.inject.Inject;
import javax.transaction.Transactional;
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

    public static final String ACCOUNT_SID = System.getenv("AC8cc7955e2ce369ae27a1977f3f784782");
    public static final String AUTH_TOKEN = System.getenv("adcbca6bbfe79d9eed6cc573cd83513e");

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
    @Path("allOpen")
    public Response getAllNotClosed() {
        return Response.ok(service.getAllOpenOrders()).build();
    }

    @PUT
    @Transactional
    @Path("close/{id}")
    public Response closeOrder(@PathParam("id") Long id) {
        this.service.close(id);
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

            String phoneText = "";

            for (var o : order.getOrderItems()) {
                var p = productService.findById(o.orderItemId.getProduct().id);
                emailText += o.getQuantity()  + "x " + p.getName() + ": " + p.getPrice() + "0 € " + "\n";
                phoneText += o.getQuantity() + "x " + p.getName() + ": " + p.getPrice() + "0 €" + "\n";
            }

            System.out.println(orderET.getId());
            System.out.println(orderET.getCustomer().getEmail());
            System.out.println(orderET.getCustomer().id);

            Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
            Message message = Message.creator(
                    new com.twilio.type.PhoneNumber("+4369919083352"),
                    new com.twilio.type.PhoneNumber("+15632278282"),
                    phoneText)
                    .create();

            System.out.println(message.getSid());


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
