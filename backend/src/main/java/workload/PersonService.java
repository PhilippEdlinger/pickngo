package workload;

import models.Customer;
import models.Person;
import workload.DTOs.SignUPDTO;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.HashMap;

@ApplicationScoped
public class PersonService {
    @Inject
    private PersonRepo repo;

    /**
     * login function of the login form by username and password
     * @param username name of the user
     * @param password password of the user
     * @return returns a signup object which is going to be trasfered
     */
    public SignUPDTO signIn(String username, String password) {
        SignUPDTO signUPDTO;
        if (repo.findByUsername(username) != null) {
            signUPDTO = signInWithusernaem(username, password);
        } else {
            signUPDTO = signInWithEmail(username, password);
        }

        if (!signUPDTO.isSuccess()) {
            signUPDTO.getMsgs().put("msg", "Ihr Benutzername, Email oder Passwort ist falsch!");
        }

        return signUPDTO;
    }

    /**
     * login by email and password
     * @param email the email of the user
     * @param password the password of the user
     * @return
     */
    public SignUPDTO signInWithEmail(String email, String password) {
        SignUPDTO signInDTO = new SignUPDTO();
        if (repo.getEntityManager().createQuery("select c from Customer c " +
                        "where c.email = :email and c.password = :password", Customer.class)
                .setParameter("email", email).setParameter("password", password).getResultList().size() > 0
        ) {
            signInDTO.setSuccess(true);
            signInDTO.setPerson(repo.findByEmail(email));
        } else {
            signInDTO.setSuccess(false);
        }

        return signInDTO;
    }

    /**
     * login function of the login form by username and password
     * @param username name of the user
     * @param password password of the user
     * @return returns a signup object which is going to be trasfered
     */
    public SignUPDTO signInWithusernaem(String username, String password) {
        SignUPDTO signInDTO = new SignUPDTO();
        if (repo.getEntityManager().createQuery("select p from Person p " +
                        "where p.username = :username and p.password = :password", Person.class)
                .setParameter("username", username).setParameter("password", password).getResultList().size() > 0
        ) {
            signInDTO.setSuccess(true);
            signInDTO.setPerson(repo.findByUsername(username));
        } else {
            signInDTO.setSuccess(false);
        }

        return signInDTO;
    }
}
