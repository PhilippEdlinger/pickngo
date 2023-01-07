package workload;

import models.OrderET;
import models.OrderStatus;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public class OrderRepository extends Repository<OrderET, Long> {
    /**
     * get a list of all oders from a certain customer
     *
     * @param customerID id of the the customer
     * @return returns a list of all orders by
     */
    public List<OrderET> getAllOrdersFromCutomer(Long customerID) {
        return getEntityManager().createQuery("select o from OrderET o " +
                        "where o.customer.id = :id", OrderET.class).setParameter("id", customerID)
                .getResultList();
    }

    public List<OrderET> getAllOpenOrders() {
        return getEntityManager()
                .createQuery("select os from OrderET os where os.orderStatus = :ost", OrderET.class)
                .setParameter("ost", OrderStatus.OPEN)
                .getResultList();
    }

    public void close(Long id) {
        var order = findById(id);
        order.setOrderStatus(OrderStatus.READY);
        getEntityManager().merge(order);
    }
}