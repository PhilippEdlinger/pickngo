package models;

import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Customer extends Person{
    @Column(unique = true)
    private String email;
    private String phoneNr;
    @OneToMany(mappedBy = "customer",cascade = CascadeType.PERSIST)
    private List<OrderET> orderETS;

    // constructor + getter and setter

    public Customer() {
    }

    public Customer(String firstName, String lastName, String userName, String password, String email, String phoneNr, List<OrderET> orderETS) {
        super(firstName, lastName, userName, password);
        this.email = email;
        this.phoneNr = phoneNr;
        this.orderETS = orderETS;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNr() {
        return phoneNr;
    }

    public void setPhoneNr(String phoneNr) {
        this.phoneNr = phoneNr;
    }

    public List<OrderET> getOrderETS() {
        return orderETS;
    }

    public void setOrderETS(List<OrderET> orderETS) {
        this.orderETS = orderETS;
    }
}
