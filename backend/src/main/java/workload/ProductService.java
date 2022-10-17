package workload;

import models.KlimaBox;
import models.Product;

import javax.enterprise.context.ApplicationScoped;
import java.util.LinkedList;
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

    public List<Product> getKlimaBox() {
        var kb = getEntityManager().createQuery("select k from KlimaBox k", KlimaBox.class).getResultList();
        List<Product> ps = new LinkedList<>();
        for (var k : kb) {
            var p = k.getProduct();
            p.setPrice(p.price * k.getRabat() / 100);
            ps.add(p);
        }

        return ps;
    }

    public List<Product> search(String sw) {
        return getEntityManager().createQuery("select p from Product p where lower(p.name) like lower(concat('%', :name, '%')) ").setParameter("name", sw).getResultList();
    }

    public List<Product> getAperitif() {
        return getEntityManager().createQuery("select p from Product p " +
                "where p.categoryET.name = 'Aperitif'").getResultList();
    }
}