package models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class OrderET extends PanacheEntityBase {
    @EmbeddedId
    public OrderID orderID;
    @Enumerated(EnumType.ORDINAL)
    public OrderStatus orderStatus;
    public LocalDateTime timeOfOrder;
    public LocalDateTime planedToPickTime;
    public LocalDateTime readyToPickTime;
    public String msg;
    @JsonIgnore
    @JsonbTransient
    @ManyToOne
    public Customer customer;
    public String phoneNR;
    @JsonIgnore
    @JsonbTransient
    @ManyToOne
    public Employee employee;
    @OneToMany(mappedBy = "orderItemID.orderET", cascade = CascadeType.ALL)
    public List<OrderItem> orderItems;

    // constructor + getter and setter

    public OrderET() {
    }

    public OrderET(OrderID orderID, OrderStatus orderStatus, LocalDateTime timeOfOrder, LocalDateTime planedToPickTime, LocalDateTime readyToPickTime, String msg, Customer customer, String phoneNR, Employee employee, List<OrderItem> orderItems) {
        this.orderID = orderID;
        this.orderStatus = orderStatus;
        this.timeOfOrder = timeOfOrder;
        this.planedToPickTime = planedToPickTime;
        this.readyToPickTime = readyToPickTime;
        this.msg = msg;
        this.customer = customer;
        this.phoneNR = phoneNR;
        this.employee = employee;
        this.orderItems = orderItems;
    }

    public OrderID getOrderID() {
        return orderID;
    }

    public void setOrderID(OrderID orderID) {
        this.orderID = orderID;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public LocalDateTime getTimeOfOrder() {
        return timeOfOrder;
    }

    public void setTimeOfOrder(LocalDateTime timeOfOrder) {
        this.timeOfOrder = timeOfOrder;
    }

    public LocalDateTime getPlanedToPickTime() {
        return planedToPickTime;
    }

    public void setPlanedToPickTime(LocalDateTime planedToPickTime) {
        this.planedToPickTime = planedToPickTime;
    }

    public LocalDateTime getReadyToPickTime() {
        return readyToPickTime;
    }

    public void setReadyToPickTime(LocalDateTime readyToPickTime) {
        this.readyToPickTime = readyToPickTime;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getPhoneNR() {
        return phoneNR;
    }

    public void setPhoneNR(String phoneNR) {
        this.phoneNR = phoneNR;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }
}
