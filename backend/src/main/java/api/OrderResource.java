package api;

import DTO.OrderDTO;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import io.quarkus.mailer.Mail;
import io.quarkus.mailer.Mailer;
import models.OrderET;
import models.OrderStatus;
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

    //sms
    public static final String ACCOUNT_SID = "AC8cc7955e2ce369ae27a1977f3f784782";
    public static final String AUTH_TOKEN = "adcbca6bbfe79d9eed6cc573cd83513e";

    @GET
    public Response getOrders() {
        return Response
                .ok(service.findAll())
                .build();
    }

    @GET
    @Path("byUserId/{id}")
    public Response getByUserId (@PathParam("id") Long id) {
        return Response.ok(this.service.getByUserId(id)).build();
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

    @GET
    @Path("{orderStat}")
    public Response getByOrderStat(@PathParam("orderStat") OrderStatus orderStatus) {
        return Response.ok(service.getByOrderStat(orderStatus)).build();
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
        Long duration = 0L;
        String text = "";

        for (var o : order.getOrderItems()) {
            var p = productService.findById(o.orderItemId.getProduct().id);
            text += o.getQuantity()  + "x " + p.getName() + ": " + p.getPrice() + "0 € " + "\n";
            duration += o.orderItemId.getProduct().getPreparationTime();
        }

        if (orderET.getCustomer() != null) {
            String emailAdress = orderET.getCustomer().getEmail();
            String emailHeader = "\n Vielen Dank, dass Sie beim Cagitzer x Pick'n'Go bestellt haben! \n \n Ihre Bestellung lautet: \n";
            String emailTime = "\n Ihre Bestellung ist in " + duration + " Minuten abholbereit! \n \n";
            String emailFooter = "\n Cagitzer x Pick'n'Go! \n Adresse: Mühlbachstraße 91, 4063 Hörsching \n Telefon: 07221 72294 \n";

            mailer.send(
                    Mail.withText(emailAdress,
                            "Ihre Bestellungsbestätigung von Pick'n'Go",
                            emailHeader + text + emailTime + emailFooter
                    )
            );
        }
        //sms
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
        Message message = Message.creator(
                        new com.twilio.type.PhoneNumber(orderET.getPhoneNr()),
                        new com.twilio.type.PhoneNumber("+15632278282"),
                        text)
                .create();

        return Response
                .ok(orderET)
                .build();
    }

    @PUT
    public Response updateOrder(OrderDTO order) {
        return Response.ok(this.service.update(order)).build();
    }

    @DELETE
    @Path("{id}/{orderPosition}")
    public Response deleteOrderById(@PathParam("id") Long orderId, @PathParam("orderPosition") Long orderPosition) {
        return Response
                .ok(service.removeById(orderId))
                .build();
    }

}
