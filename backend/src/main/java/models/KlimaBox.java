package models;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class KlimaBox {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Product product;
    private Double discount;
    private LocalDateTime fromDate;
    private LocalDateTime toDate;

    private Integer quantity;



    public KlimaBox() {
    }

    public KlimaBox(Product product, Double discount, LocalDateTime fromDate, LocalDateTime toDate, Integer quantity) {
        this.product = product;
        this.discount = discount;
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.quantity = quantity;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public LocalDateTime getFromDate() {
        return fromDate;
    }

    public void setFromDate(LocalDateTime fromDate) {
        this.fromDate = fromDate;
    }

    public LocalDateTime getToDate() {
        return toDate;
    }

    public void setToDate(LocalDateTime toDate) {
        this.toDate = toDate;
    }
}
