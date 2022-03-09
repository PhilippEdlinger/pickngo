package models;

import javax.persistence.*;
import java.util.List;

@Entity
public class Employee extends Person {
    @OneToMany(mappedBy = "employee", cascade = CascadeType.REFRESH)
    public List<OrderET> orderETs;

    // constructor + getter and setter
    public Employee() {
    }

    public Employee(String firstName, String lastName, String userName, String password, List<OrderET> orderETs) {
        super(firstName, lastName, userName, password);
        this.orderETs = orderETs;
    }
}
