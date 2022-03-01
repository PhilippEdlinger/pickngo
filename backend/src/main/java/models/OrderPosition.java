package models;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class OrderPosition {
    @EmbeddedId
    private OrderPositionID orderPositionID;
    private Integer quantity;
    private String message;

    public OrderPosition() {
    }

    public OrderPosition(OrderPositionID orderPositionID, Integer quantity, String message) {
        this.orderPositionID = orderPositionID;
        this.quantity = quantity;
        this.message = message;
    }

    public OrderPositionID getOrderPositionID() {
        return orderPositionID;
    }

    public void setOrderPositionID(OrderPositionID orderPositionID) {
        this.orderPositionID = orderPositionID;
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
