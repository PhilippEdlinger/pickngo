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

    public SignUPDTO signInWithusernaem(String username, String password) {
        SignUPDTO signInDTO = new SignUPDTO();
        var yo = "select p from Person p " +
                "where p.userName = :username and p.password = :password";
        if (repo.getEntityManager().createQuery("select p from Person p " +
                        "where p.userName = :username and p.password = :password", Person.class)
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
