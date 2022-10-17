package models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.*;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Product extends PanacheEntityBase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    public String name;
    public String description;
    public Double price;
    public String imageName;
    public String allergies;
    public Integer preparationTime;
    @JsonIgnore
    @JsonbTransient
    @OneToMany(mappedBy = "orderItemId.product")
    public List<OrderItem> orderItems;
    @ManyToOne
    public CategoryET categoryET;
    @JsonIgnore
    @JsonbTransient
    @ManyToMany
    @JoinTable(name = "menu_product",
            inverseJoinColumns = @JoinColumn(name = "menu_id",
                    nullable = false,
                    updatable = false),
            joinColumns = @JoinColumn(name = "product_id",
                    nullable = false,
                    updatable = false),
            foreignKey = @ForeignKey(ConstraintMode.CONSTRAINT),
            inverseForeignKey = @ForeignKey(ConstraintMode.CONSTRAINT))
    public List<Menu> menus;
    @ManyToMany(
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.REFRESH,
                    CascadeType.DETACH,
                    CascadeType.MERGE
            })
    @JoinTable(name = "product_tag",
            inverseJoinColumns = @JoinColumn(name = "tag_id",
                    nullable = false,
                    updatable = false),
            joinColumns = @JoinColumn(name = "product_id",
                    nullable = false,
                    updatable = false),
            foreignKey = @ForeignKey(ConstraintMode.CONSTRAINT),
            inverseForeignKey = @ForeignKey(ConstraintMode.CONSTRAINT))
    public List<Tag> tags;

    // constructor + getter and setter

    public Product() {
    }

    public Product(String name, Double price, String description,String imageName, String allergies, Integer preparationTime, List<OrderItem> orderItems, CategoryET categoryET, List<Menu> menus, List<Tag> tags) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.imageName = imageName;
        this.allergies = allergies;
        this.preparationTime = preparationTime;
        this.orderItems = orderItems;
        this.categoryET = categoryET;
        this.menus = menus;
        this.tags = tags;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
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

    public List<Menu> getMenus() {
        return menus;
    }

    public void setMenus(List<Menu> menus) {
        this.menus = menus;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }
}
