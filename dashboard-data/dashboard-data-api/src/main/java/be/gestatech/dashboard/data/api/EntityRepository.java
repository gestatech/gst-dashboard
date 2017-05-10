package be.gestatech.dashboard.data.api;

import java.io.Serializable;
import java.util.List;

import javax.persistence.metamodel.SingularAttribute;

/**
 * Created by amurifa on 10/05/2017.
 */
public interface EntityRepository<E, PK extends Serializable> extends EntityPersistenceRepository<E, PK>, EntityCountRepository<E> {

    E findBy(PK primaryKey);

    List<E> findAll();

    List<E> findAll(int start, int max);

    List<E> findBy(E example, SingularAttribute<E, ?>... attributes);

    List<E> findBy(E example, int start, int max, SingularAttribute<E, ?>... attributes);

    List<E> findByLike(E example, SingularAttribute<E, ?>... attributes);

    List<E> findByLike(E example, int start, int max, SingularAttribute<E, ?>... attributes);
}
