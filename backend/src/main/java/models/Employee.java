package models;

import javax.persistence.*;
import java.util.List;

@Entity
public class Employee extends Person {
    @OneToMany(mappedBy = "employee", cascade = CascadeType.REFRESH)
    private List<OrderET> orderETs;

    // constructor + getter and setter
    public Employee() {
    }

    public Employee(String firstName, String lastName, List<OrderET> orderETs) {
        super(firstName, lastName);
        this.orderETs = orderETs;
    }

    public List<OrderET> getOrderETs() {
        return orderETs;
    }

    public void setOrderETs(List<OrderET> orderETs) {
        this.orderETs = orderETs;
    }
}
