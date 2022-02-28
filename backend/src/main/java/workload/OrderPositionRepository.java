package workload;

import models.OrderET;
import models.OrderPosition;
import models.OrderPositionID;
import models.Product;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public class OrderPositionRepository extends Repository<OrderPosition, OrderPositionID> {

    public List<OrderPosition> getOrderPosition(OrderET order, Product product    ) throws IllegalArgumentException {
        var query = getEntityManager().createQuery(
                "select o " +
                        "from OrderPosition o " +
                        "where o.orderPositionID.orderET >= :order " +
                        "and o.orderPositionID.product <= :product ",
                OrderPosition.class
        );

        query.setParameter("order", order);
        query.setParameter("product", product);

        return query.getResultList();
    }

}
