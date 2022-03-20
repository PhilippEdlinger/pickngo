package workload;

import models.OrderItem;
import models.OrderItemID;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class OrderPositionRepository extends Repository<OrderItem, OrderItemID> {
}
