package models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import javax.json.bind.annotation.JsonbDateFormat;
import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class OrderET extends PanacheEntityBase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long orderPosition;
    @Enumerated(EnumType.ORDINAL)
    public OrderStatus orderStatus;
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    public LocalDateTime timeOfOrder;
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    public LocalDateTime planedToPickTime;
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    public LocalDateTime readyToPickTime;
    public String msg;
    @ManyToOne
    public Customer customer;
    public String phoneNr;
    @JsonIgnore
    @JsonbTransient
    @ManyToOne
    public Employee employee;
    @OneToMany(mappedBy = "orderItemId.orderET", cascade = CascadeType.ALL)
    public List<OrderItem> orderItems;

    // constructor + getter and setter

    public OrderET() {
    }

    public OrderET(Long orderPosition, OrderStatus orderStatus, LocalDateTime timeOfOrder, LocalDateTime planedToPickTime, LocalDateTime readyToPickTime, String msg, Customer customer, String phoneNr, Employee employee, List<OrderItem> orderItems) {
        this.orderPosition = orderPosition;
        this.orderStatus = orderStatus;
        this.timeOfOrder = timeOfOrder;
        this.planedToPickTime = planedToPickTime;
        this.readyToPickTime = readyToPickTime;
        this.msg = msg;
        this.customer = customer;
        this.phoneNr = phoneNr;
        this.employee = employee;
        this.orderItems = orderItems;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOrderPosition() {
        return orderPosition;
    }

    public void setOrderPosition(Long orderPosition) {
        this.orderPosition = orderPosition;
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

    public String getPhoneNr() {
        return phoneNr;
    }

    public void setPhoneNr(String phoneNr) {
        this.phoneNr = phoneNr;
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
