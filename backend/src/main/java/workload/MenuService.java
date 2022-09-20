package workload;

import models.Menu;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public class MenuService extends Repository<Menu, Long>{

    public List<Menu> getAll() {
        return findAll().list();
    }

    public Menu getById(Long id) {
        return findById(id);
    }

    public Menu add(Menu menu) {
        persistET(menu);
        return findById(menu.id);
    }

    public Menu update(Menu menu) {
        return updateET(menu);
    }

    public Boolean delete(Long id) {
        return removeById(id);
    }

    public List<Menu> getDishOfTheDay() {
        return getEntityManager().createQuery("select m from Menu m where m.isDishOfTheDay = true", Menu.class).getResultList();
    }
}
