package models;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Customer {
    @Id
    private Long id;
    private String firstName;
    private String lastName;
    private String phoneNr;
    private String email;
    @OneToMany(cascade = CascadeType.PERSIST)
    private List<OrderET> orderETS;

    // constructor + getter and setter

    public Customer() {
    }

    public Customer(Long id, String firstName, String lastName, String phoneNr, String email, List<OrderET> orderETS) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNr = phoneNr;
        this.email = email;
        this.orderETS = orderETS;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNr() {
        return phoneNr;
    }

    public void setPhoneNr(String phoneNr) {
        this.phoneNr = phoneNr;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<OrderET> getOrderETS() {
        return orderETS;
    }

    public void setOrderETS(List<OrderET> orderETS) {
        this.orderETS = orderETS;
    }
}
