package workload;

import models.Person;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class PersonRepo extends Repository<Person, Long> {
    /**
     * gets a person/user by name
     * @param username name of the past user
     * @return returns a person object of the desired person
     */
    public Person findByUsername(String username) {
        return getEntityManager().createQuery("select p from Person p " +
                        "where p.username = :un", Person.class)
                .setParameter("un", username)
                .getResultStream().findFirst().orElse(null);
    }

    public Person findByEmail(String email) {
        return getEntityManager().createQuery("select c from Customer c " +
                        "where c.email = :email", Person.class)
                .setParameter("email", email)
                .getResultStream().findFirst().orElse(null);
    }
}
