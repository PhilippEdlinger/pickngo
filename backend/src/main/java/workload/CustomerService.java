package workload;

import models.Customer;
import workload.DTOs.SignUPDTO;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@ApplicationScoped
public class CustomerService {
    @Inject
    private CustomerRepository repo;
    
    /**
     * get all customers
     * @return returns a list from all Customer
     */
    public List<Customer> findAll() {
        return repo.findAll().list();
    }

    /**
     * get Customer by id
     * @param id
     * @return returns desired customer
     */
    public Customer findById(Long id) {
        return repo.findById(id);
    }

    /**
     * update Customer 
     * @param customer to be updated customer
     * @return returns updated customer
     */
    public Customer updateET(Customer customer) {
        repo.updateET(customer);
        return customer;
    }

    /**
     * signup customer
     * @param customer to be persistet cutomer
     * @return returns a signUpDTO object
     */
    public SignUPDTO signUP(Customer customer) {
        SignUPDTO signUPDTO = checkCustomer(customer);;

        if (signUPDTO.isSuccess()) {
            repo.persistET(customer);
            signUPDTO.setPerson(customer);
        }
        return signUPDTO;
    }

    /*
    public SignUPDTO signIn(String useranme, String password) {
        SignUPDTO signInDTO = new SignUPDTO();
        if (repo.getEntityManager().createQuery("select c from Customer c " +
                        "where c.userName = :username and c.password = :password", Customer.class)
                .setParameter("username", useranme).setParameter("password", password).getResultList().size() > 0
                || repo.getEntityManager().createQuery("select c from Customer c " +
                        "where c.email = :username and c.password = :password", Customer.class)
                .setParameter("username", useranme).setParameter("password", password).getResultList().size() > 0
        ) {
            signInDTO.setSuccess(true);
            signInDTO.setCustomer(repo.finByUsername(useranme));
        } else {
            signInDTO.setSuccess(false);
            signInDTO.setMsgs(new HashMap<>());
            signInDTO.getMsgs().put("msg", "Username oder Password ist falsch!");
        }

        return signInDTO;
    }*/

    /**
     * checks if the customer information is viable
     * @param customer customer object which is going to be checked
     * @return returns a SignUPDTO
     */
    private SignUPDTO checkCustomer(Customer customer) {
        SignUPDTO signUPDTO = new SignUPDTO();

        Pattern pattern = Pattern
                .compile("^[A-zäöüßÄÖÜ\\.\\_\\-\\d]{2,40}@([A-z\\-\\_]+\\.){1,5}[A-z]{2,10}$");

        if (customer.getUsername() == null || customer.getUsername().length() <= 5) {
            signUPDTO.getMsgs().put("username", "Der Benutzername muss mehr als 5 Zeichen haben!");
            signUPDTO.setSuccess(false);
        }
        if (customer.getEmail() == null || customer.getEmail().length() < 7) {
            signUPDTO.getMsgs().put("email", "Die Email Addresse muss mehr als 6 Zeichen haben!");
            signUPDTO.setSuccess(false);
        }

        if (customer.getPassword() == null || customer.getPassword().length() < 7 ) {
            signUPDTO.getMsgs().put("password", "Das Passwort Addresse muss mehr als 6 Zeichen haben!");
            signUPDTO.setSuccess(false);
        }
        if (usernameExists(customer.getUsername())) {
            signUPDTO.getMsgs().put("username", "Der Username " + customer.getUsername() + " exisitiert schon!");
            signUPDTO.setSuccess(false);
        }
        if (emailExists(customer.getEmail())) {
            signUPDTO.getMsgs().put("email", "Die Email Addresse " + customer.getEmail() + " exisitiert schon!");
            signUPDTO.setSuccess(false);
        }

        if (!pattern.matcher(customer.getEmail()).find()) {
            signUPDTO.getMsgs().put("email", "Die Email Addresse muss ein richtiges Format haben!");
            signUPDTO.setSuccess(false);
        }

        if (signUPDTO.getMsgs().size() <= 0) {
            signUPDTO.setSuccess(true);
        }

        return signUPDTO;
    }

    /**
     * checks if the username exists 
     * @param username to be checked username
     * @return returns a boolean depending on if it's true.
     */
    private boolean usernameExists(String username) {
        return repo.getEntityManager().createQuery("select c from Customer c " +
                        "where c.username= :username", Customer.class)
                .setParameter("username", username).getResultList().size() > 0;
    }

    /**
     * checks if the past email is aviable 
     * @param email to be checked email
     * @return return a boolean depending on if the statement is true
     */
    private boolean emailExists(String email) {
        return repo.getEntityManager().createQuery("select c from Customer c " +
                        "where c.email = :email", Customer.class)
                .setParameter("email", email).getResultList().size() > 0;
    }
}
