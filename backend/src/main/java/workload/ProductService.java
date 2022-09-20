package workload;

import models.Product;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public class ProductService extends Repository<Product, Long> {

    public List<Product> getVorspeise() {
        return getEntityManager().createQuery("select p from Product p " +
                "where p.categoryET.name = 'Vorspeise'").getResultList();
    }

    public List<Product> getHauptspeise() {
        return getEntityManager().createQuery("select p from Product p " +
                "where p.categoryET.name = 'Hauptspeise'").getResultList();
    }

    public List<Product> getDesert() {
        return getEntityManager().createQuery("select p from Product p " +
                "where p.categoryET.name = 'Desert'").getResultList();
    }
}
