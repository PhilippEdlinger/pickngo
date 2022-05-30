package workload;

import models.Customer;
import workload.DTOs.SignUPDTO;

import java.util.HashMap;

public class PersonService {
    public SignUPDTO signIn(String useranme, String password) {
        public void y() {

        }
    }
        /*
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
    }
    */

}
