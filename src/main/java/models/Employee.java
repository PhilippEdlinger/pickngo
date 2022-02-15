package models;

import javax.persistence.*;
import java.util.List;

@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String lastName;
    private String FirstName;
    @OneToMany(cascade = CascadeType.REFRESH)
    private List<OrderET> orderETs;

    // constructor + getter and setter

    public Employee() {
    }

    public Employee(Long id, String lastName, String firstName, List<OrderET> orderETs) {
        this.id = id;
        this.lastName = lastName;
        FirstName = firstName;
        this.orderETs = orderETs;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public List<OrderET> getOrderETs() {
        return orderETs;
    }

    public void setOrderETs(List<OrderET> orderETs) {
        this.orderETs = orderETs;
    }
}
