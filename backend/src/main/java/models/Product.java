package models;

import javax.persistence.*;
import java.util.List;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToMany(mappedBy = "orderItemID.product")
    private List<OrderItem> orderItems;
    @ManyToOne
    private CategoryET categoryET;
    private String imagePath;
    private String name;
    private Double price;
    private String allergies;

    // constructor + getter and setter

    public Product() {
    }

    public Product(List<OrderItem> orderItems, CategoryET categoryET, String imagePath, String name, Double price, String allergies) {
        this.orderItems = orderItems;
        this.categoryET = categoryET;
        this.imagePath = imagePath;
        this.name = name;
        this.price = price;
        this.allergies = allergies;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<OrderItem> getOrderPositions() {
        return orderItems;
    }

    public void setOrderPositions(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    public CategoryET getCategory() {
        return categoryET;
    }

    public void setCategory(CategoryET categoryET) {
        this.categoryET = categoryET;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
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

    public String getAllergies() {
        return allergies;
    }

    public void setAllergies(String allergies) {
        this.allergies = allergies;
    }
}
