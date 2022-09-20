package workload;

import models.OrderET;
import models.OrderItem;
import models.OrderStatus;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalUnit;
import java.util.List;

@ApplicationScoped
public class OrderService {
    @Inject
    private OrderRepository repo;

    public List<OrderET> findAll() {
        return repo.findAll().list();
    }


    public OrderET findById(Long orderId) {
        return repo.findById(orderId);
    }

    public List<OrderItem> getAllOrderItemsFrom(Long id) {
        return repo.getEntityManager().createQuery("select oi from OrderItem oi " +
                        "where oi.orderItemId.orderET.id = :orderID", OrderItem.class)
                .setParameter("orderID", id).getResultList();
    }

    public OrderET persistET(OrderET order) {
        var id = repo.getEntityManager().createQuery("select max(o.id) from OrderET o", Long.class).getSingleResult();
        var orderPosition = repo.getEntityManager().createQuery("select o.orderPosition " +
                "from OrderET o " +
                "where o.id = :id", Long.class).setParameter("id", id).getSingleResult();
        LocalDateTime ready = LocalDateTime.now();

        order.setOrderPosition(orderPosition >= 20 ? 1 : orderPosition + 1);
        order.getOrderItems().stream().forEach(oi -> {
            oi.getOrderItemId().setOrderET(order);
            ready.plusMinutes(oi.getOrderItemId().getProduct().preparationTime);
        });
        order.setOrderStatus(OrderStatus.IN_PRODUCTION);
        order.setTimeOfOrder(LocalDateTime.now());
        order.setReadyToPickTime(ready);
/*        if (Duration.between(LocalTime.parse(order.getPlanedToPickTime().toString(), DateTimeFormatter.ISO_LOCAL_DATE),
                LocalTime.parse(ready.toString(), DateTimeFormatter.ISO_LOCAL_DATE)).isNegative()) {

        }
*/
        repo.persistET(order);
        return findById(id + 1);
    }

    public Boolean removeById(Long orderId) {
        return repo.removeById(orderId);
    }
}
