package models;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import javax.persistence.*;
import java.util.List;

@Entity
public class CategoryET extends PanacheEntityBase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    @Column(unique = true)
    public String name;

    @OneToMany(mappedBy = "categoryET",cascade = CascadeType.REFRESH)
    public List<Product> product;

    // constructor + getter and setter

    public CategoryET() {
    }

    public CategoryET(String name, List<Product> product) {
        this.name = name;
        this.product = product;
    }
}
