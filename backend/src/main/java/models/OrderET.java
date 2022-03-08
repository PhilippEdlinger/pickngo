package models;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class OrderET extends PanacheEntityBase {
    @EmbeddedId
    public OrderID orderID;
    public OrderStatus orderStatus;
    public LocalDateTime timeOfOrder;
    public LocalDateTime planedToPickTime;
    public LocalDateTime readyToPickTime;
    public String msg;
    @ManyToOne
    public Customer customer;
    @ManyToOne
    public Employee employee;
    @OneToMany(mappedBy = "orderItemID.orderET", cascade = CascadeType.ALL)
    public List<OrderItem> orderItems;

    // constructor + getter and setter

    public OrderET() {
    }

    public OrderET(OrderID orderID, OrderStatus orderStatus, LocalDateTime timeOfOrder, LocalDateTime planedToPickTime, LocalDateTime readyToPickTime, String msg, Customer customer, Employee employee, List<OrderItem> orderItems) {
        this.orderID = orderID;
        this.orderStatus = orderStatus;
        this.timeOfOrder = timeOfOrder;
        this.planedToPickTime = planedToPickTime;
        this.readyToPickTime = readyToPickTime;
        this.msg = msg;
        this.customer = customer;
        this.employee = employee;
        this.orderItems = orderItems;
    }
}
