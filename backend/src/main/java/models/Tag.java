package models;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import javax.persistence.*;
import java.util.List;

@Entity
public class Tag extends PanacheEntityBase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    public Long name;
    @ManyToMany
    public List<Product> products;

    public Tag() {
    }

    public Tag(Long id, Long name) {
        this.id = id;
        this.name = name;
    }
}
