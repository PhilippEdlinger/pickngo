package models;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.*;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)

public abstract class Product extends PanacheEntityBase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    public String name;
    public Double price;
    public String imagePath;
    public String allergies;
    public Integer preparationTime;
    @JsonbTransient
    @OneToMany(mappedBy = "orderItemID.product")
    public List<OrderItem> orderItems;
    @ManyToOne
    public CategoryET categoryET;
    @JsonbTransient
    @ManyToOne
    public Menu menu;
    @ManyToMany(mappedBy = "products")
    public List<Tag> tags;

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getAllergies() {
        return allergies;
    }

    public void setAllergies(String allergies) {
        this.allergies = allergies;
    }

    public Integer getPreparationTime() {
        return preparationTime;
    }

    public void setPreparationTime(Integer preparationTime) {
        this.preparationTime = preparationTime;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    public CategoryET getCategoryET() {
        return categoryET;
    }

    public void setCategoryET(CategoryET categoryET) {
        this.categoryET = categoryET;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }
}
