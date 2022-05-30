package workload;

import models.Customer;
import workload.DTOs.SignUPDTO;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;

@ApplicationScoped
public class CustomerService {
    @Inject
    private CustomerRepository repo;

    public List<Customer> findAll() {
        return repo.findAll().list();
    }

    public Customer findById(Long id) {
        return repo.findById(id);
    }

    public Customer updateET(Customer customer) {
        repo.updateET(customer);
        return customer;
    }

    public SignUPDTO signUP(Customer customer) {

        return checkCustomer(customer);
    }

    private SignUPDTO checkCustomer(Customer customer) {
        SignUPDTO signUPDTO = new SignUPDTO();
        if (repo.getEntityManager().createQuery("select c from Customer c " +
                "where c.userName = :username", Customer.class)
                .setParameter("username", customer.userName).getSingleResult() != null) {
            signUPDTO.getMsgs().put("username", "Username " + customer.userName + "exisitiert schon!");
        }

        return signUPDTO;
    }
}
