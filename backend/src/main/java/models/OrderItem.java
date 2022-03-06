package models;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class OrderItem {
    @EmbeddedId
    private OrderItemID orderItemID;
    private Integer quantity;
    private String message;

    public OrderItem() {
    }

    public OrderItem(OrderItemID orderItemID, Integer quantity, String message) {
        this.orderItemID = orderItemID;
        this.quantity = quantity;
        this.message = message;
    }

    public OrderItemID getOrderPositionID() {
        return orderItemID;
    }

    public void setOrderPositionID(OrderItemID orderItemID) {
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
