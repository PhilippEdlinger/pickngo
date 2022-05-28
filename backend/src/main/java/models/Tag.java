package models;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import javax.persistence.*;
import java.util.List;

@Entity
public class Tag extends PanacheEntityBase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    public String name;
    @ManyToMany
    public List<Product> products;

    public Tag() {
    }

    public Tag(String name, List<Product> products) {
        this.name = name;
        this.products = products;
    }
}
