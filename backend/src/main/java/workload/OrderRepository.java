package workload;

import models.OrderET;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public class OrderRepository extends Repository<OrderET, Long> {
    public List<OrderET> getAllOrdersFromCutomer(Long customerID) {
        return getEntityManager().createQuery("select o from OrderET o " +
                "where o.customer.id = :id", OrderET.class).setParameter("id", customerID)
                .getResultList();
    }
}
