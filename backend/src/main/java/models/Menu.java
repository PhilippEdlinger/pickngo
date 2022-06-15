package models;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.*;
import java.util.List;

@Entity
public class Menu extends PanacheEntityBase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    public Double price;
    @ManyToMany(
            cascade = {
                    CascadeType.REFRESH,
                    CascadeType.DETACH,
                    CascadeType.MERGE
            })
    @JoinTable(name = "menu_product",
            inverseJoinColumns = @JoinColumn(name = "product_id",
                    nullable = false,
                    updatable = false),
            joinColumns = @JoinColumn(name = "menu_id",
                    nullable = false,
                    updatable = false),
            foreignKey = @ForeignKey(ConstraintMode.CONSTRAINT),
            inverseForeignKey = @ForeignKey(ConstraintMode.CONSTRAINT))
    public List<Product> products;
    public Boolean isDishOfTheDay;

    // constructor + getter and setter
    public Menu() {
    }

    public Menu(Double price, List<Product> products, Boolean isDishOfTheDay) {
        this.price = price;
        this.products = products;
        this.isDishOfTheDay = isDishOfTheDay;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public Boolean getDishOfTheDay() {
        return isDishOfTheDay;
    }

    public void setDishOfTheDay(Boolean dishOfTheDay) {
        isDishOfTheDay = dishOfTheDay;
    }
}
