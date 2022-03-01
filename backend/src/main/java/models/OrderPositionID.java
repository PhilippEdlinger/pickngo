package models;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class OrderPositionID implements Serializable {
    @ManyToOne
    private OrderET orderET;
    private Long orderPosition;
    @ManyToOne(cascade = CascadeType.PERSIST)
    private Product product;

    public OrderPositionID() {
    }

    public OrderPositionID(OrderET orderET, Long orderPosition, Product product) {
        this.orderET = orderET;
        this.orderPosition = orderPosition;
        this.product = product;
    }

    public OrderET getOrderET() {
        return orderET;
    }

    public void setOrderET(OrderET orderET) {
        this.orderET = orderET;
    }

    public Long getOrderPosition() {
        return orderPosition;
    }

    public void setOrderPosition(Long orderPosition) {
        this.orderPosition = orderPosition;
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
        OrderPositionID that = (OrderPositionID) o;
        return orderET.equals(that.orderET) && orderPosition.equals(that.orderPosition) && product.equals(that.product);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderET, orderPosition, product);
    }
}
