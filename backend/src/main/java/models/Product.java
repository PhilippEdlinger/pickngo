package models;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.*;
import java.util.List;

@Entity
public abstract class Product extends PanacheEntity {
    public String name;
    public Double price;
    public String imagePath;
    public String allergies;
    public Integer preparationTime;
    @OneToMany(mappedBy = "orderItemID.product")
    public List<OrderItem> orderItems;
    @ManyToOne
    public CategoryET categoryET;
    @ManyToOne
    public Menu menu;

    // constructor + getter and setter

    public Product() {
    }

    public Product(String name, Double price, String imagePath, String allergies, Integer preparationTime, List<OrderItem> orderItems, CategoryET categoryET) {
        this.name = name;
        this.price = price;
        this.imagePath = imagePath;
        this.allergies = allergies;
        this.preparationTime = preparationTime;
        this.orderItems = orderItems;
        this.categoryET = categoryET;
    }
}
