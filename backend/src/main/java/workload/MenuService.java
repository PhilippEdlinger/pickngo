package workload;

import models.Menu;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public class MenuService extends Repository<Menu, Long>{

    /**
     * get all Menus
     * @return return a list of all Menus
     */
    public List<Menu> getAll() {
        return findAll().list();
    }

    /**
     * get menu by id
     * @param id id of the menu
     * @return returns the desired menu
     */
    public Menu getById(Long id) {
        return findById(id);
    }

    /**
     * save a new menu
     * @param menu past to be added menu object
     * @return returns the persisted menu
     */
    public Menu add(Menu menu) {
        persistET(menu);
        return findById(menu.id);
    }

    /**
     * updates menu
     * @param menu  to be updated menu object
     * @return
     */
    public Menu update(Menu menu) {
        return updateET(menu);
    }

    /**
     * deltes a menu
     * @param id id of menu object
     * @return returns a boolean 
     */
    public Boolean delete(Long id) {
        return removeById(id);
    }

    /**
     * get the dishes/products of the day 
     * @return returns a list of menus
     */
    public List<Menu> getDishOfTheDay() {
        return getEntityManager().createQuery("select m from Menu m where m.isDishOfTheDay = true", Menu.class).getResultList();
    }
}
