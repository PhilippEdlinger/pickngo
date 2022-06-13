package workload;

import models.OrderET;
import models.OrderID;
import models.OrderItem;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;

@ApplicationScoped
public class OrderService {
    @Inject
    private OrderRepository repo;

    public List<OrderET> findAll() {
        return repo.findAll().list();
    }


    public OrderET findById(Long orderId, Long orderPosition) {
        OrderID orderID = new OrderID(orderId, orderPosition);
        return repo.findById(orderID);
    }

    public List<OrderItem> getAllOrderItemsFrom(OrderID orderID) {
        return repo.getEntityManager().createQuery("select oi from OrderItem oi " +
                "where oi.orderItemID.orderET.orderID = :orderID", OrderItem.class)
                .setParameter("orderID", orderID).getResultList();
    }

    public OrderET persistET(OrderET order) {
        var id = repo.getEntityManager().createQuery("select max(o.orderID.id) from OrderET o", Long.class).getSingleResult();
        var orderPosition = repo.getEntityManager().createQuery("select o.orderID.orderPosition " +
                "from OrderET o " +
                "where o.orderID.id = :id", Long.class).setParameter("id", id).getSingleResult();
        var orderID = new OrderID(id + 1, orderPosition >= 20 ? 1 : orderPosition + 1);

        order.setOrderID(orderID);
        order.getOrderItems().stream().forEach(oi -> {oi.getOrderItemID().setOrderET(order);});
        repo.persistET(order);
        return findById(id, orderPosition);
    }

    public Boolean removeById(Long orderId, Long orderPosition) {
        OrderID orderID = new OrderID(orderId, orderPosition);
        return repo.removeById(orderID);
    }
}
