package models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.*;
import java.util.List;

@Entity
public class Employee extends Person {
    @OneToMany(mappedBy = "employee", cascade = CascadeType.REFRESH)
    @JsonIgnore
    @JsonbTransient
    public List<OrderET> orderETs;

    // constructor + getter and setter
    public Employee() {
    }

    public Employee(String firstName, String lastName, String userName, String password, List<OrderET> orderETs) {
        super(firstName, lastName, userName, password);
        this.orderETs = orderETs;
    }

    public List<OrderET> getOrderETs() {
        return orderETs;
    }

    public void setOrderETs(List<OrderET> orderETs) {
        this.orderETs = orderETs;
    }
}
