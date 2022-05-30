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
}
