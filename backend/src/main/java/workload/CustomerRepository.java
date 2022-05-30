package workload;

import models.Customer;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class CustomerRepository extends Repository<Customer, Long> {
    public Customer finByUsername(String username) {
        return getEntityManager().createQuery("select c from Customer c " +
                        "where c.userName = :un", Customer.class)
                .setParameter("un", username)
                .getResultStream().findFirst().orElse(null);
    }
}
