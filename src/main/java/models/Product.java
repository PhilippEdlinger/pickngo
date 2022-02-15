package models;

import javax.persistence.*;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private OrderPosition orderPosition;
    @ManyToOne(cascade = CascadeType.REFRESH)
    private Category category;
    private String imagePath;
    private String name;
    private Double price;
    private String allergies;

    // constructor + getter and setter

    public Product() {
    }

    public Product(Long id, OrderPosition orderPosition, Category category, String imagePath, String name, Double price, String allergies) {
        this.id = id;
        this.orderPosition = orderPosition;
        this.category = category;
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

    public OrderPosition getOrderPosition() {
        return orderPosition;
    }

    public void setOrderPosition(OrderPosition orderPosition) {
        this.orderPosition = orderPosition;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
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
