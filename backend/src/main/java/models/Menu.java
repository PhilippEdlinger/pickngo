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
    @JsonbTransient
    @OneToMany(mappedBy = "menu", cascade = CascadeType.ALL)
    public List<Product> items;
    public Boolean isDishOfTheDay;

    // constructor + getter and setter
    public Menu() {
    }

    public Menu(Double price, List<Product> items, Boolean isDishOfTheDay) {
        this.price = price;
        this.items = items;
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

    public List<Product> getItems() {
        return items;
    }

    public void setItems(List<Product> items) {
        this.items = items;
    }

    public Boolean getDishOfTheDay() {
        return isDishOfTheDay;
    }

    public void setDishOfTheDay(Boolean dishOfTheDay) {
        isDishOfTheDay = dishOfTheDay;
    }
}
