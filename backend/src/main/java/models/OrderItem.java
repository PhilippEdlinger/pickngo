package models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class OrderItem extends PanacheEntityBase {
    @EmbeddedId
    @JsonIgnore
    public OrderItemID orderItemID;
    public Integer quantity;
    public String message;

    public OrderItem() {
    }

    public OrderItem(OrderItemID orderItemID, Integer quantity, String message) {
        this.orderItemID = orderItemID;
        this.quantity = quantity;
        this.message = message;
    }

    public OrderItemID getOrderItemID() {
        return orderItemID;
    }

    public void setOrderItemID(OrderItemID orderItemID) {
        this.orderItemID = orderItemID;
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
