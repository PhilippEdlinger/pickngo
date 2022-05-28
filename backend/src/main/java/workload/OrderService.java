package workload;

import models.OrderET;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;

@ApplicationScoped
public class OrderService {
    @Inject
    private OrderRepository repo;

    public List<OrderET> findAll() {
        return repo.findAll().list();
    }


    public OrderET findById(Long orderId) {
        return repo.findById(orderId);
    }

    public OrderET updateET(OrderET order) {
        return repo.updateET(order);
    }

    public Boolean removeById(Long orderId) {
        return repo.removeById(orderId);
    }
}
