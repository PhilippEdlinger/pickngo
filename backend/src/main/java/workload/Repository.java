package workload;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import javax.transaction.Transactional;

public abstract class Repository<Entity, Identification> implements PanacheRepositoryBase<Entity, Identification> {

    @Transactional
    public Entity updateET(Entity entity) {
        return getEntityManager().merge(entity);
    }

    @Transactional
    public void persistET(Entity entity) {
        persist(entity);
    }

    @Transactional
    public boolean removeById(Identification id) {
        return deleteById(id);
    }

    @Transactional
    public void remove(Entity entity) {
        delete(entity);
    }
}

