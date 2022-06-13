package workload;

import models.OrderET;
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


    public OrderET findById(Long orderId) {
        return repo.findById(orderId);
    }

    public List<OrderItem> getAllOrderItemsFrom(Long id) {
        return repo.getEntityManager().createQuery("select oi from OrderItem oi " +
                "where oi.orderItemID.orderET.id = :orderID", OrderItem.class)
                .setParameter("orderID", id).getResultList();
    }

    public OrderET persistET(OrderET order) {
        var id = repo.getEntityManager().createQuery("select max(o.id) from OrderET o", Long.class).getSingleResult();
        var orderPosition = repo.getEntityManager().createQuery("select o.orderPosition " +
                "from OrderET o " +
                "where o.id = :id", Long.class).setParameter("id", id).getSingleResult();

        order.setOrderPosition(orderPosition >= 20 ? 1 : orderPosition + 1);
        order.getOrderItems().stream().forEach(oi -> {oi.getOrderItemID().setOrderET(order);});
        repo.persistET(order);
        return findById(id);
    }

    public Boolean removeById(Long orderId) {
        return repo.removeById(orderId);
    }
}
