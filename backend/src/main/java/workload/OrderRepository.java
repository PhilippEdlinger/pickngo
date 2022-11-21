package workload;

import models.OrderET;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public class OrderRepository extends Repository<OrderET, Long> {
    /**
     * get a list of all oders from a certain customer
     * @param customerID id of the the customer
     * @return returns a list of all orders by 
     */
    public List<OrderET> getAllOrdersFromCutomer(Long customerID) {
        return getEntityManager().createQuery("select o from OrderET o " +
                "where o.customer.id = :id", OrderET.class).setParameter("id", customerID)
                .getResultList();
    }
}
