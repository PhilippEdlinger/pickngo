package workload.DTOs;

import models.Customer;
import models.Person;

import java.util.HashMap;

public class SignUPDTO {
    private boolean success;
    private HashMap<String, String> msgs = new HashMap<>();
    private Person person;

    public SignUPDTO() {
    }

    public SignUPDTO(boolean success) {
        this.success = success;
    }

    public SignUPDTO(boolean success, HashMap<String, String> msgs) {
        this.success = success;
        this.msgs = msgs;
    }

    public SignUPDTO(boolean success, HashMap<String, String> msgs, Person person) {
        this.success = success;
        this.msgs = msgs;
        this.person = person;
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

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
