package models;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class OrderET {
    @Id
    private Long id;
    @ManyToOne
    private Customer customer;
    @ManyToOne
    private Employee employee;
    @OneToMany(mappedBy = "orderPositionID.orderET", cascade = CascadeType.ALL)
    private List<OrderPosition> orderPositions;
    private LocalDateTime timeStamp;

    // constructor + getter and setter

    public OrderET() {
    }

    public OrderET(Long id, Customer customer, Employee employee, List<OrderPosition> orderPositions, LocalDateTime timeStamp) {
        this.id = id;
        this.customer = customer;
        this.employee = employee;
        this.orderPositions = orderPositions;
        this.timeStamp = timeStamp;
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

    public List<OrderPosition> getOrderPositions() {
        return orderPositions;
    }

    public void setOrderPositions(List<OrderPosition> orderPositions) {
        this.orderPositions = orderPositions;
    }

    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(LocalDateTime timeStamp) {
        this.timeStamp = timeStamp;
    }
}
