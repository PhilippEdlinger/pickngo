package workload;

import models.OrderET;
import models.OrderID;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class OrderRepository extends Repository<OrderET, OrderID> {
}
