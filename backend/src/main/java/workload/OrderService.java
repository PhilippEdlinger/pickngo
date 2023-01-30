package workload;

import DTO.OrderDTO;
import DTO.OrderItemDTO;
import models.*;
import org.hibernate.criterion.Order;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalUnit;
import java.util.LinkedList;
import java.util.List;

@ApplicationScoped
public class OrderService {
    @Inject
    private OrderRepository repo;
    @Inject
    private CustomerRepository customerRepo;
    @Inject
    private ProductService productService;

    /**
     * get all orders
     *
     * @return returns a list of all orders
     */
    public List<OrderET> findAll() {
        return repo.findAll().list();
    }

    /**
     * find orders by id
     *
     * @param orderId the id of the desired order
     * @return returns an object of the order
     */
    public OrderET findById(Long orderId) {
        return repo.findById(orderId);
    }

    /**
     * a list of all items/products which are in an order
     *
     * @param id identification of the past order
     * @return returns a list of all orderitems of this particular order
     */
    public List<OrderItem> getAllOrderItemsFrom(Long id) {
        return repo.getEntityManager().createQuery("select oi from OrderItem oi " +
                        "where oi.orderItemId.orderET.id = :orderID", OrderItem.class)
                .setParameter("orderID", id).getResultList();
    }

    /**
     * persist an order
     *
     * @param order the to be persisted order
     * @return returns the newly added order
     */
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

    /**
     * removes an order by id
     *
     * @param orderId id of the removed order object
     * @return returns a boolean
     */
    public Boolean removeById(Long orderId) {
        return repo.removeById(orderId);
    }

    public List<OrderET> getAllOpenOrders() {
        this.repo.getAllOpenOrders().forEach(orderET -> {
            System.out.println(orderET.getOrderStatus());
        });
        return this.repo.getAllOpenOrders();
    }

    public List<OrderET> getByOrderStat(OrderStatus orderStatus) {
        return this.repo.getByOrderStat(orderStatus);
    }

    public void close(Long id) {
        repo.close(id);
    }

    public OrderET update(OrderDTO o) {
        var c = customerRepo.findById(o.customer_id == null ? -1 : o.customer_id);
        var order = new OrderET(o.getId(), o.getOrderPosition(), o.getOrderStatus(), o.getTimeOfOrder(), o.getPlanedToPickTime(), o.getReadyToPickTime(), o.msg, c, o.getPhoneNr(), null, null);

        List<OrderItem> orderItems = new LinkedList<>();
        o.orderItems.forEach(oi -> {
            var p = productService.findById(oi.getProduct_id());
            orderItems.add(new OrderItem(new OrderItemID(order, p), oi.getQuantity(), oi.getMessage()));
        });
        order.setOrderItems(orderItems);

        return this.repo.updateET(order);
    }

    public List<OrderET> getByUserId(Long id) {
        return repo.getEntityManager().createQuery("select o from OrderET o where o.customer.id = :id", OrderET.class)
                .setParameter("id", id)
                .getResultList();
    }
}
