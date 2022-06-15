package models;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class OrderItem extends PanacheEntityBase {
    @EmbeddedId
    public OrderItemID orderItemId;
    public Integer quantity;
    public String message;

    public OrderItem() {
    }

    public OrderItem(OrderItemID orderItemId, Integer quantity, String message) {
        this.orderItemId = orderItemId;
        this.quantity = quantity;
        this.message = message;
    }

    public OrderItemID getOrderItemId() {
        return orderItemId;
    }

    public void setOrderItemId(OrderItemID orderItemId) {
        this.orderItemId = orderItemId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
