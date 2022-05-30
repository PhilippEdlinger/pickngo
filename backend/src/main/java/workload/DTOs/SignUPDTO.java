package workload.DTOs;

import models.Customer;

import java.util.HashMap;

public class SignUPDTO {
    private boolean success;
    private HashMap<String, String> msgs;
    private Customer customer;

    public SignUPDTO() {
    }

    public SignUPDTO(boolean success) {
        this.success = success;
    }

    public SignUPDTO(boolean success, HashMap<String, String> msgs) {
        this.success = success;
        this.msgs = msgs;
    }

    public SignUPDTO(boolean success, HashMap<String, String> msgs, Customer customer) {
        this.success = success;
        this.msgs = msgs;
        this.customer = customer;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public HashMap<String, String> getMsgs() {
        return msgs;
    }

    public void setMsgs(HashMap<String, String> msgs) {
        this.msgs = msgs;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
