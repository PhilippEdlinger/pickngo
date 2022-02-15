package models;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Customer extends Person{
    private String phoneNr;
    private String email;
    @OneToMany(cascade = CascadeType.PERSIST)
    private List<OrderET> orderETS;

    // constructor + getter and setter

    public Customer() {
    }

    public Customer(String firstName, String lastName, String phoneNr, String email, List<OrderET> orderETS) {
        super(firstName, lastName);
        this.phoneNr = phoneNr;
        this.email = email;
        this.orderETS = orderETS;
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
