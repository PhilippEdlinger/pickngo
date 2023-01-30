package DTO;

import models.OrderItem;
import models.OrderStatus;

import java.time.LocalDateTime;
import java.util.List;

public class OrderDTO {
    private Long id;
    private Long orderPosition;
    public OrderStatus orderStatus;
    public LocalDateTime timeOfOrder;
    public LocalDateTime planedToPickTime;
    public LocalDateTime readyToPickTime;
    public String msg;
    public Long customer_id;
    public String phoneNr;
    public Long employee_id;
    public List<OrderItemDTO> orderItems;

    public OrderDTO() {
    }

    public OrderDTO(Long id, Long orderPosition, OrderStatus orderStatus, LocalDateTime timeOfOrder, LocalDateTime planedToPickTime, LocalDateTime readyToPickTime, String msg, Long customer_id, String phoneNr, Long employee_id, List<OrderItemDTO> orderItems) {
        this.id = id;
        this.orderPosition = orderPosition;
        this.orderStatus = orderStatus;
        this.timeOfOrder = timeOfOrder;
        this.planedToPickTime = planedToPickTime;
        this.readyToPickTime = readyToPickTime;
        this.msg = msg;
        this.customer_id = customer_id;
        this.phoneNr = phoneNr;
        this.employee_id = employee_id;
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

    public Long getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(Long customer_id) {
        this.customer_id = customer_id;
    }

    public String getPhoneNr() {
        return phoneNr;
    }

    public void setPhoneNr(String phoneNr) {
        this.phoneNr = phoneNr;
    }

    public Long getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(Long employee_id) {
        this.employee_id = employee_id;
    }

    public List<OrderItemDTO> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItemDTO> orderItems) {
        this.orderItems = orderItems;
    }
}
