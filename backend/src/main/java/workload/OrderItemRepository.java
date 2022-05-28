package workload;

import models.OrderItem;
import models.OrderItemID;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class OrderItemRepository extends Repository<OrderItem, OrderItemID> {
}
