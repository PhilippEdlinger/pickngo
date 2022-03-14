package models;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import javax.persistence.*;
import java.util.List;

@Entity
public class Menu extends PanacheEntityBase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    public Double price;
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
}
