package models;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class OrderItemID implements Serializable {
    private Long orderPosition;
    @ManyToOne
    private OrderET orderET;
    @ManyToOne(cascade = CascadeType.PERSIST)
    private Product product;

    public OrderItemID() {
    }

    public OrderItemID(Long orderPosition, OrderET orderET, Product product) {
        this.orderPosition = orderPosition;
        this.orderET = orderET;
        this.product = product;
    }

    public Long getOrderPosition() {
        return orderPosition;
    }

    public void setOrderPosition(Long orderPosition) {
        this.orderPosition = orderPosition;
    }

    public OrderET getOrderET() {
        return orderET;
    }

    public void setOrderET(OrderET orderET) {
        this.orderET = orderET;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderItemID that = (OrderItemID) o;
        return orderET.equals(that.orderET) && product.equals(that.product);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderET, product);
    }
}
