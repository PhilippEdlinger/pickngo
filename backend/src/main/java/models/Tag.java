package models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.*;
import java.util.List;

@Entity
public class Tag extends PanacheEntityBase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    public String name;
    @JsonIgnore
    @JsonbTransient
    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.REFRESH,
            CascadeType.DETACH,
            CascadeType.MERGE
    })
    @JoinTable(name = "product_tag",
            inverseJoinColumns = @JoinColumn(name = "product_id",
                    nullable = false,
                    updatable = false),
            joinColumns = @JoinColumn(name = "tag_id",
                    nullable = false,
                    updatable = false),
            foreignKey = @ForeignKey(ConstraintMode.CONSTRAINT),
            inverseForeignKey = @ForeignKey(ConstraintMode.CONSTRAINT))
    public List<Product> products;

    public Tag() {
    }

    public Tag(String name, List<Product> products) {
        this.name = name;
        this.products = products;
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

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
