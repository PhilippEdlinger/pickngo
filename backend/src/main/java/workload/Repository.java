package workload;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import javax.transaction.Transactional;

public abstract class Repository<Entity, Identification> implements PanacheRepositoryBase<Entity, Identification> {

    /**
     * updates an object in the db
     * @param entity entity/object which is going to be updated in the DB
     * @return returns the updated entity
     */
    @Transactional
    public Entity updateET(Entity entity) {
        return getEntityManager().merge(entity);
    }

    /**
     * saves/persist an object in the DB
     * @param entity the object which is being persited in the DB
     */
    @Transactional
    public void persistET(Entity entity) {
        persist(entity);
    }

    /**
     * removes an object by the id
     * @param id id of the desired object which is going to be deleted
     * @return returns the deleted object
     */
    @Transactional
    public boolean removeById(Identification id) {
        return deleteById(id);
    }

    /**
     * removes an db object by the past object
     * @param entity object which is going to be deleted 
     */
    @Transactional
    public void remove(Entity entity) {
        delete(entity);
    }
}

