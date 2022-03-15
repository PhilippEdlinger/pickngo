package models;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Menu extends PanacheEntity {
    @OneToMany(mappedBy = "menu", cascade = CascadeType.ALL)
    public List<Product> items;

    // constructor + getter and setter

    public Menu() {
    }

    public Menu(List<Product> items) {
        this.items = items;
    }
}
