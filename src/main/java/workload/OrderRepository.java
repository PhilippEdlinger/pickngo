package workload;

import models.OrderET;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class OrderRepository extends Repository<OrderET, Long> {
}
