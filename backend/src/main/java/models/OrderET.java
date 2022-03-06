package models;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class OrderET {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime readyToPickTime;
    private Boolean isReady;
    private LocalDateTime timeOfOrder;
    private String msg;
    @ManyToOne
    private Customer customer;
    @ManyToOne
    private Employee employee;
    @OneToMany(mappedBy = "orderItemID.orderET", cascade = CascadeType.ALL)
    private List<OrderItem> orderItems;

    // constructor + getter and setter

    public OrderET() {
    }

    public OrderET(LocalDateTime readyToPickTime, Boolean isReady, LocalDateTime timeOfOrder, String msg, Customer customer, Employee employee, List<OrderItem> orderItems) {
        this.readyToPickTime = readyToPickTime;
        this.isReady = isReady;
        this.timeOfOrder = timeOfOrder;
        this.msg = msg;
        this.customer = customer;
        this.employee = employee;
        this.orderItems = orderItems;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public List<OrderItem> getOrderPositions() {
        return orderItems;
    }

    public void setOrderPositions(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    public LocalDateTime getTimeOfOrder() {
        return timeOfOrder;
    }

    public void setTimeOfOrder(LocalDateTime timeStamp) {
        this.timeOfOrder = timeStamp;
    }

    public LocalDateTime getReadyToPickTime() {
        return readyToPickTime;
    }

    public void setReadyToPickTime(LocalDateTime readyToPickTime) {
        this.readyToPickTime = readyToPickTime;
    }

    public Boolean getReady() {
        return isReady;
    }

    public void setReady(Boolean ready) {
        isReady = ready;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
