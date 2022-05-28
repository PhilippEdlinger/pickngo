package workload;

import models.Product;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ProductRepository extends Repository<Product, Long> {
}
