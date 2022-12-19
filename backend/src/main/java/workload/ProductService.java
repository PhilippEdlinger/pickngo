package workload;

import models.KlimaBox;
import models.Menu;
import models.Product;

import javax.enterprise.context.ApplicationScoped;
import java.util.LinkedList;
import java.util.List;


@ApplicationScoped
public class ProductService extends Repository<Product, Long> {

    /**
     * gets a list of all products by the category Vorspeise 
     * @return returns a list of products 
     */
    public List<Product> getVorspeise() {
        return getEntityManager().createQuery("select p from Product p " +
                "where p.categoryET.name = 'Vorspeise'").getResultList();
    }

    /**
     * gets a list of all products by the category Hauptspeise 
     * @return returns a list of products 
     */
    public List<Product> getHauptspeise() {
        return getEntityManager().createQuery("select p from Product p " +
                "where p.categoryET.name = 'Hauptspeise'").getResultList();
    }

    /**
     * gets a list of all products by the category Desert 
     * @return returns a list of products 
     */
    public List<Product> getDesert() {
        return getEntityManager().createQuery("select p from Product p " +
                "where p.categoryET.name = 'Desert'").getResultList();
    }

    /**
     * gets a list of all products which are type of Klimabox
     * @return returns a list of products 
     */
    public List<KlimaBox> getKlimaBox() {
        var kb = getEntityManager().createQuery("select k from KlimaBox k", KlimaBox.class).getResultList();
        for (var k : kb) {
            kb.getProduct().setPrice(p.price * k.getDiscount() / 100);
        }

        return kb;
    }

    /**
     * searches through all products to find the desired one
     * @param sw is the searched word or product which is looked after 
     * @return returns a list off all fitting products
     */
    public List<Product> search(String sw) {
        return getEntityManager().createQuery("select p from Product p where lower(p.name) like lower(concat('%', :name, '%')) ").setParameter("name", sw).getResultList();
    }

    /**
     * gets a list of all products by the category Aperitif 
     * @return returns a list of products 
     */
    public List<Product> getAperitif() {
        return getEntityManager().createQuery("select p from Product p " +
                "where p.categoryET.name = 'Aperitif'").getResultList();
    }

}