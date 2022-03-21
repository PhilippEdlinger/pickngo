package workload;

import models.Customer;

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
        return repo.updateET(customer);
    }
}
