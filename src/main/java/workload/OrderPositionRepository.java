package workload;

import models.OrderPosition;
import models.OrderPositionID;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class OrderPositionRepository extends Repository<OrderPosition, OrderPositionID> {
}
